package com.diguage.didp.bridge;

/**
 * @author D瓜哥，https://www.diguage.com/
 * @since 2017-05-26
 */
public class Client {
  public static void main(String[] args) {
    Abstraction abstraction = new RefinedAbstraction();
    abstraction.setImplementor(new ConcreteImplementorA());
    abstraction.operation();


    abstraction.setImplementor(new ConcreteImplementorB());
    abstraction.operation();
  }
}
