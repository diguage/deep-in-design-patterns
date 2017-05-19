#!/bin/bash

sed=`which sed`
if [[ `uname` == Darwin* ]]
then
  sed=`which gsed`
fi

project_dir=`pwd`
java_base_pkg="com.diguage.didp"
base_pkg_dir="${project_dir}/src/main/java/`echo $java_base_pkg | $sed 's/\./\//g'`"
book_dir="${project_dir}/book"

for uml in `ls ${project_dir}/puml/*.puml`;
do
  echo $uml;

  file_name=`echo $uml | awk -F/ '{print $NF}' | awk -F. '{print $1}'`
  pkg=`echo $file_name | $sed 's/-//g'`
  pkg_path=${base_pkg_dir}/${pkg}

  echo "${book_dir}/${file_name}.adoc"

  # 遍历数组，获取下标以及各个元素
  for cf in `ls $pkg_path`;
  do

    # 提取类名
    class_path="/${pkg}/${cf}";

    class_name=`echo $cf | awk -F. '{print $1}'`

include_src=$(cat<<EOF

[source,{java_source_attr}]
.${class_name} 类
----
include::{source_dir}${class_path}[]
----

EOF
)

    echo "${include_src}"
  done
done
