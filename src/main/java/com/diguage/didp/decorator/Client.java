package com.diguage.didp.decorator;

/**
 * Client 类
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2017-05-16
 */
public class Client {
  public static void main(String[] args) {
    Component component = new ConcreteComponent();
    Decorator decoratorA = new ConcreteDecoratorA();
    Decorator decoratorB = new ConcreteDecoratorB();
    decoratorA.setComponent(component);
    decoratorB.setComponent(decoratorA);
    decoratorB.operation();
  }
}
