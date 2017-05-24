package com.diguage.didp.templatemethod;

/**
 * @author diguage
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
