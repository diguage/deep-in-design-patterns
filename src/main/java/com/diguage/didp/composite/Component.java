package com.diguage.didp.composite;

/**
 * Component 类
 *
 * @author D瓜哥，http://www.diguage.com/
 * @since 2017-05-23 09:09:48
 */
public abstract class Component {
  public abstract void add(Component component);
  public abstract void remove(Component component);
  public abstract void display(int depth);
}
