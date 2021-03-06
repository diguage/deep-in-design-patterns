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

  pkg=`echo $uml | awk -F/ '{print $NF}' | awk -F. '{print $1}' | $sed 's/-//g'`

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

    class_sign=`$sed -n "${start}, ${end}p" $uml | grep class | awk -F{ '{print $1}' | $sed 's/^\s*//g' | $sed 's/\s*$//g'`;
    # echo "==${class_sign}=="

    now=`date "+%Y-%m-%d %H:%M:%S"`;

    # 创建包
    pkg_path=${base_pkg_dir}/${pkg}
    mkdir -p $pkg_path

    # 创建类
    class_file_name=$pkg_path/${class_name}.java
    rm $class_file_name
    touch $class_file_name

    echo -e "package ${java_base_pkg}.${pkg};\n" >> $class_file_name

javadoc=$(cat<<EOF
/**
 * $class_name 类
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since $now
 */
EOF
)
    echo "${javadoc}" >> $class_file_name
    echo "public ${class_sign} {" >> $class_file_name

    # 如果类为空，则不需要继续处理
    if [ $[$start+1] -ne $end ]
    then
      # 截取出方法来
      # 将 + 换成 public
      # 将 - 换成 private
      # 去掉 abstract 两边的大括号
      # 去掉 static 两边的大括号
      # 调整方法参数声明的语法 -- 这里只有一个参数
      # 调整方法返回值的语法
      # 添加没有声明返回值的方法的语法
      # 调整抽象方法添加分号结尾
      # 调整非抽象方法添加大括号
      # 调整属性声明的语法
      $sed -n "$[${start}+1], $[${end}-1]p" $uml \
        | $sed "s/+/public/g" \
        | $sed "s/-/private/g" \
        | $sed "s/{\(abstract\)}/\1/g" \
        | $sed "s/{\(static\)}/\1/g" \
        | $sed "s/(\(\w*\)\s*:\s*\(\w*\))/(\2 \1)/g" \
        | $sed "s/\s*\(\w*(.*)\)\s*:\s*\(\w*\)/ \2 \1/g" \
        | $sed "s/\(public\|public\s\+abstract\)\s\+\(\w*(\)/\1 void \2/g" \
        | $sed "s/\(abstract.*)\)\s*$/\1;/g" \
        | $sed "s/)[^;]*$/) {\n  }/g" \
        | $sed "s/\(private\)\s*\(\w*\)\s*:\s*\(\w*\)/\1 \3 \2;/g" \
        >> $class_file_name;
    fi

    # 结束类
    echo "}" >> $class_file_name;

    # 处理泛化和实现
    relationship=`grep -E "<\|[-.]{2}\s*${class_name}" $uml | $sed "s/\(\w\+\)\s*<|\(..\) \(.*\)/\2/g"`
    super_class=`grep -E "<\|[-.]{2}\s*${class_name}" $uml | awk '{print $1}'`
    # echo "=${class_name}=__=${relationship}=__=${super_class}="
    if [[ -n $super_class ]]; then
      if [ "$relationship" = ".." ]; then
        relationship=implements
      fi

      if [ "$relationship" = "--" ]; then
        relationship=extends
      fi

      # echo "=${class_name}=__=${relationship}=__=${super_class}="
      $sed -i "s/$class_name\s\+{/$class_name ${relationship} ${super_class} {/g" $class_file_name
    fi
  done
done
