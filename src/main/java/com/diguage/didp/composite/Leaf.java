package com.diguage.didp.composite;

/**
 * Leaf 类
 *
 * @author D瓜哥，http://www.diguage.com/
 * @since 2017-05-23 09:09:48
 */
public class Leaf extends Component {
  public Leaf(String name) {
    super(name);
  }

  @Override
  public void add(Component component) {
    throw new UnsupportedOperationException("不支持向叶子中添加元素！");
  }

  @Override
  public void remove(Component component) {
    throw new UnsupportedOperationException("不支持向叶子中删除元素！");
  }

  @Override
  public void display(int depth) {
    StringBuilder sb = new StringBuilder(depth + name.length());
    for (int i = 0; i < depth; i++) {
      sb.append("-");
    }
    System.out.println(sb.append(name).toString());
  }
}
