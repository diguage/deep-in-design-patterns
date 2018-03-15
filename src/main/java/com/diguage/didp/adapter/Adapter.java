package com.diguage.didp.adapter;

/**
 * Adapter 类
 *
 * @author D瓜哥，https://www.diguage.com/
 * @since 2017-05-19 17:53:33
 */
public class Adapter extends Target {
  private Adaptee adaptee = new Adaptee();

  public void request() {
    adaptee.specificRequest();
  }
}
