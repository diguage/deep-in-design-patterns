package com.diguage.didp.composite;

/**
 * Component 类
 *
 * @author D瓜哥，https://www.diguage.com/
 * @since 2017-05-23 09:09:48
 */
public abstract class Component {
  protected String name;

  public Component(String name) {
    this.name = name;
  }

  public abstract void add(Component component);

  public abstract void remove(Component component);

  public abstract void display(int depth);
}
