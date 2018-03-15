package com.diguage.didp.prototype;

/**
 * Client 类
 *
 * @author D瓜哥，https://www.diguage.com/
 * @since 2017-05-19 17:53:35
 */
public class Client {
  public static void main(String[] args) {
    Prototype p1 = new ConcretePrototype1();
    Prototype p2 = p1.clone();
  }
}
