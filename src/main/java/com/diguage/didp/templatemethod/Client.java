package com.diguage.didp.templatemethod;

/**
 * @author D瓜哥，https://www.diguage.com/
 * @since 2017-05-24
 */
public class Client {
  public static void main(String[] args) {
    AbstractClass c;
    c = new ConcreteClassA();
    c.templateMethod();

    c = new ConcreteClassB();
    c.templateMethod();
  }
}
