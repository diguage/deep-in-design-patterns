package com.diguage.didp.iterator;

/**
 * Iterator 类
 *
 * @author D瓜哥，https://www.diguage.com/
 * @since 2017-05-19 17:53:35
 */
public abstract class Iterator {
  public abstract Object first();

  public abstract Object next();

  public abstract boolean isDone();

  public abstract Object currentItem();
}
