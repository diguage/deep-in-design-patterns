#!/bin/bash

sed=`which sed`
if [[ `uname` == Darwin* ]]
then
  sed=`which gsed`
fi

# 第一个参数：adoc 文件路径
# 第二个参数：需要扫描的文件或者目录
# 第二个参数：基础包路径
function recursiveAddSrcFileToAdoc {
  local afn=$1;
  local pp=$2;
  local bp=$3;
  if [[ -f $pp ]]; then

    id=`echo ${bp} | awk -F. '{print $1}' | $sed "s#/#-#g" | awk '{print tolower($0)}'`
    # echo "$a" | tr '[:upper:]' '[:lower:]' # 也可以这样大写转小写
    sid="src-${id}"
    # 判断所需要添加的类是否已经包含在文件中，没有才执行添加操作
    if `grep -q ${bp} ${afn}; [ $? -eq 1 ]`; then
# 是文件就加入到文件中
include_src=$(cat<<EOF

[source,{java_source_attr}]
.${bp} 类
[[${sid}]]
----
include::{source_dir}/${bp}[]
----

EOF
)
      echo "${include_src}" >> ${afn};
    fi

    cn=`echo ${bp} | awk -F/ '{print $NF}' | awk -F. '{print $1}'`
    $sed -i "s#^\.${cn} 类#\.${bp} 类#g" ${afn};

    # 添加 ID
    if `grep -q "\[\[${sid}\]\]" ${afn}; [ $? -eq 1 ]`; then
      $sed -i "s#\(^\.${bp} 类\)#\1\n[[${sid}]]#g" ${afn};
    fi
  elif [[ -d $pp ]]; then
    # 如果是目录，则递归扫描该目录
    for f in `ls $pp `;
    do
      recursiveAddSrcFileToAdoc $afn "${pp}/${f}" "${bp}/${f}"
    done
  fi
}



project_dir=`pwd`
java_base_pkg="com.diguage.didp"
base_pkg_dir="${project_dir}/src/main/java/`echo $java_base_pkg | $sed 's/\./\//g'`"
book_dir="${project_dir}/book"

for uml in `ls ${project_dir}/puml/*.puml`;
do
  file_name=`echo $uml | awk -F/ '{print $NF}' | awk -F. '{print $1}'`
  pkg=`echo $file_name | $sed 's/-//g'`
  pkg_path=${base_pkg_dir}/${pkg}

  adoc_file_name="${book_dir}/${file_name}.adoc"

  recursiveAddSrcFileToAdoc $adoc_file_name $pkg_path $pkg
done


echo "Finish dealing!"
