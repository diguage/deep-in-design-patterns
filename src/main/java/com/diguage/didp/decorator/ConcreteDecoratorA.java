package com.diguage.didp.decorator;

/**
 * 具体装饰 A 类
 *
 * @author D瓜哥，https://www.diguage.com/
 * @since 2017-05-16
 */
public class ConcreteDecoratorA extends Decorator {

  private String addedState;

  @Override
  public void operation() {
    super.operation();
    addedState = "区别于其他装饰对象的状态值！";
    System.out.println("具体装饰对象 A 的操作");
  }
}
