package com.diguage.didp.abstractfactory;

/**
 * ConcreteFactory2 类
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2017-05-19 17:53:33
 */
public class ConcreteFactory2 extends AbstractFactory {
  public AbstractProductA createProductA() {
    return new ProductA2();
  }

  public AbstractProductB createProductB() {
    return new ProductB2();
  }
}
