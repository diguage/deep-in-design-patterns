package com.diguage.didp.factorymethod;

/**
 * ConcreteFactory 类
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2017-05-23 09:09:48
 */
public class ConcreteFactory extends Factory {
  public Product factoryMethod() {
    return new ConcreteProduct();
  }
}
