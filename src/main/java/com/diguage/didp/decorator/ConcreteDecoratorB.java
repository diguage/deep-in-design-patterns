package com.diguage.didp.decorator;

/**
 * 具体装饰 B 类
 *
 * @author diguage
 * @since 2017-05-16
 */
public class ConcreteDecoratorB extends Decorator {

  private String addedState;

  @Override
  public void operation() {
    super.operation();
    addedState = "区别于其他装饰对象的状态值！";
    addBehavior();
  }

  private void addBehavior() {
    System.out.println("附加的装饰动作！");
  }
}
