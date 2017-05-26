package com.diguage.didp.visitor;

/**
 * ConcreteElementA 类
 *
 * @author D瓜哥，http://www.diguage.com/
 * @since 2017-05-19 17:53:36
 */
public class ConcreteElementA extends Element {
  @Override
  public void accept(Vistor vistor) {
    vistor.visitConcreteElementA(this);
  }

  public void operatorA() {
    System.out.println("B其他操作");
  }
}
