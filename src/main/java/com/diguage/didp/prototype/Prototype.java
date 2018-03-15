package com.diguage.didp.prototype;

/**
 * Prototype 类
 *
 * @author D瓜哥，https://www.diguage.com/
 * @since 2017-05-19 17:53:35
 */
public abstract class Prototype {
  protected int id = 0;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public abstract Prototype clone();
}
