package com.diguage.didp.visitor;

/**
 * Element 类
 *
 * @author D瓜哥，http://www.diguage.com/
 * @since 2017-05-19 17:53:36
 */
public abstract class Element {
  public abstract Object accept(Vistor vistor);
}
