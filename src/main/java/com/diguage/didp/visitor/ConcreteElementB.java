package com.diguage.didp.visitor;

/**
 * ConcreteElementB 类
 *
 * @author D瓜哥，http://www.diguage.com/
 * @since 2017-05-19 17:53:36
 */
public class ConcreteElementB extends Element {
  @Override
  public void accept(Vistor vistor) {
    vistor.visitConcreteElementB(this);
  }

  public void operatorB() {
    System.out.println("B其他操作");
  }
}
