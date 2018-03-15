#!/bin/bash

base_dir=`pwd`
origin_file_name=deep-in-design-patterns
adoc_file_name=${origin_file_name}.adoc
origin_html_file_name=${origin_file_name}.html
web_html_file_name=index.html
style_dir=./target/styles

# 解决 Mac 与 Linux 中 sed 处理不统一的问题
gsed=`which sed`
if [[ `uname` == Darwin* ]]
then
  gsed=`which gsed`
fi

# 确保 cssnano 命令被安装
cssnano=`which cssnano`
if [ ! -n `which cssnano` ]; then
  npm install cssnano-cli --g --registry=https://registry.npm.taobao.org
  cssnano=`which cssnano`
fi

# 确保 html-minifier 命令被安装
htmlminifier=`which html-minifier`
if [ ! -n `which html-minifier` ]; then
  npm install html-minifier -g --registry=https://registry.npm.taobao.org
  htmlminifier=`which html-minifier`
fi

rm -rf $origin_html_file_name $web_html_file_name target
#
# rake book:build
mkdir -p target/images/images
mkdir -p target/images/uml
mkdir -p target/styles
cp book/images/* target/images/images/

asciidoctor -r asciidoctor-diagram deep-in-design-patterns.adoc

cd $style_dir

for f in `ls .`
do
  # 压缩 CSS
  $cssnano $f $f
done

cd $base_dir

# 替换 Font Awesome，使用内置功能，不需要手动搞了。
# $gsed -i "s/https:\/\/cdnjs.cloudflare.com\/ajax\/libs/http:\/\/cdn.bootcss.com/" $html_file_name

# 调整样式
$gsed -i "s/<\/head>/<style>a{text-decoration:none;}<\/style><\/head>/" $origin_html_file_name

# 替换 Font Awesome，(内置功能不能保证版本一致)
$gsed -i "s/https:\/\/cdnjs.cloudflare.com\/ajax\/libs/\/\/cdn.bootcss.com/" $origin_html_file_name
# 替换 Google Fonts
$gsed -i "s/https:\/\/fonts.googleapis.com/\/\/fonts.proxy.ustclug.org/" $origin_html_file_name

$htmlminifier -c html-minifier.config.json $origin_html_file_name -o $web_html_file_name

rsync -avz --exclude=".*" src ./$web_html_file_name ./target  deployer@notes.diguage.com:/home/deployer/diguage.com/notes/design-patterns
