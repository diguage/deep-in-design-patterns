package com.diguage.didp.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite 类
 *
 * @author D瓜哥，https://www.diguage.com/
 * @since 2017-05-23 09:09:48
 */
public class Composite extends Component {
  private List<Component> children = new ArrayList<>();

  public Composite(String name) {
    super(name);
  }

  @Override
  public void add(Component component) {
    children.add(component);
  }

  @Override
  public void remove(Component component) {
    children.remove(component);
  }

  @Override
  public void display(int depth) {
    StringBuilder sb = new StringBuilder(depth + name.length());
    for (int i = 0; i < depth; i++) {
      sb.append("-");
    }
    System.out.println(sb.append(name).toString());

    children.forEach(s -> s.display(depth + 2));
  }
}
