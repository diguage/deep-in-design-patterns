#!/bin/bash

sed=`which sed`
if [[ `uname` == Darwin* ]]
then
  sed=`which gsed`
fi

project_dir=`pwd`
java_base_pkg="com.diguage.didp"
base_pkg_dir="${project_dir}/src/main/java/`echo $java_base_pkg | $sed 's/\./\//g'`"

for uml in `ls ${project_dir}/puml/*.puml`;
do
  echo $uml;

  pkg=`echo $uml | awk -F/ '{print $NF}' | awk -F. '{print $1}'`

  ## 提取每个类开始和结束行号
  declare -a start_lines=(`awk '/class/{print NR}' $uml`)
  declare -a end_lines=(`awk '/^}/{print NR}' $uml`)

  # 获取数组长度
  arraylength=${#start_lines[@]}

  # 遍历数组，获取下标以及各个元素
  for (( i=0; i<${arraylength}; i++ ));
  do
    start=${start_lines[$i]};
    end=${end_lines[$i]};

    # 提取类名
    class_name=`$sed -n "${start}, ${end}p" $uml | grep class | awk -Fclass '{print $2}' | awk '{print $1}'`;
    echo $class_name;

    class_sign=`$sed -n "${start}, ${end}p" $uml | grep class | awk -F{ '{print $1}'`;

    now=`date "+%Y-%m-%d %H:%M:%S"`;

    # 创建包
    pkg_path=${base_pkg_dir}/${pkg}
    mkdir -p $pkg_path

    # 创建类
    class_file_name=$pkg_path/${class_name}.class
    touch $class_file_name

    echo -e "package ${java_base_pkg}.${pkg};\n" >> $class_file_name

javadoc=$(cat<<EOF
/**
 * $class_name 类
 *
 * @author D瓜哥，http://www.diguage.com/
 * @since $now
 */
EOF
)
    echo "${javadoc}" >> $class_file_name
    echo "public ${class_sign} {" >> $class_file_name

    # 如果类为空，则不需要继续处理
    if [ $[$start+1] -eq $end ]
    then
      echo "}" >> $class_file_name
      continue;
    fi


    # 截取出方法来
    # 将 + 换成 public
    # 将 - 换成 private
    # 去掉 abstract 两边的大括号
    # 去掉 static 两边的大括号
    # 调整方法参数声明的语法 -- 这里只有一个参数
    # 调整方法返回值的语法
    # 添加没有声明返回值的方法的语法 ??
    # 调整抽象方法添加分号结尾
    # 调整非抽象方法添加大括号
    # 调整属性声明的语法
    $sed -n "$[${start}+1], $[${end}-1]p" $uml \
      | $sed "s/+/public/g" \
      | $sed "s/-/private/g" \
      | $sed "s/{\(abstract\)}/\1/g" \
      | $sed "s/{\(static\)}/\1/g" \
      | $sed "s/(\(\w*\)\W*:\W*\(\w*\))/(\2 \1)/g" \
      | $sed "s/\W*\(\w*(.*)\)\W*:\W*\(\w*\)/ \2 \1/g" \
      | $sed "s/\(public\|public\W*abstract\)\W*\(\)/\1 void \2/g" \
      | $sed "s/\(abstract.*)\)\W*$/\1;/g" \
      | $sed "s/\()\)\W*$/\1 {\n  }/g" \
      | $sed "s/\(private\)\W*\(\w*\)\W*:\W*\(\w*\)/\1 \3 \2;/g" \
      >> $class_file_name;

    # 结束类
    echo "}" >> $class_file_name;
  done
done
