package com.diguage.didp.visitor;

/**
 * ConcreteVisitor2 类
 *
 * @author D瓜哥，https://www.diguage.com/
 * @since 2017-05-23 09:09:50
 */
public class ConcreteVisitor2 extends Vistor {
  @Override
  public void visitConcreteElementA(ConcreteElementA element) {
    System.out.printf("%s 被 %s 访问%n", //
        element.getClass().getName(), this.getClass().getName());
  }

  @Override
  public void visitConcreteElementB(ConcreteElementB element) {
    System.out.printf("%s 被 %s 访问%n", //
        element.getClass().getName(), this.getClass().getName());
  }
}
