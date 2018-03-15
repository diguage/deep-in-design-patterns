package com.diguage.didp.factorymethod;

/**
 * @author D瓜哥，https://www.diguage.com/
 * @since 2017-05-24
 */
public class Client {
  public static void main(String[] args) {
    Factory factory = new ConcreteFactory();
    Product product = factory.factoryMethod();
    System.out.println(product.getClass().getName());
  }
}
