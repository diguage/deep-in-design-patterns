package com.diguage.didp.abstractfactory;

/**
 * ConcreteFactory1 类
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2017-05-19 17:53:33
 */
public class ConcreteFactory1 extends AbstractFactory {
  public AbstractProductA createProductA() {
    return new ProductA1();
  }

  public AbstractProductB createProductB() {
    return new ProductB1();
  }
}
