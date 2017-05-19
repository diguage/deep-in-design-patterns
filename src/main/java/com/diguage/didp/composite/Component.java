package com.diguage.didp.composite;

/**
 * Component 类
 *
 * @author D瓜哥，http://www.diguage.com/
 * @since 2017-05-19 17:53:34
 */
public abstract class Component {
  public abstract add(Component component);
  public abstract remove(Component component);
  public abstract display(int depth);
}
