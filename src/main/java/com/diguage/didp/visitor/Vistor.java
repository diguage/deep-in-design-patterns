package com.diguage.didp.visitor;

/**
 * Vistor 类
 *
 * @author D瓜哥，https://www.diguage.com/
 * @since 2017-05-23 09:09:50
 */
public abstract class Vistor {
  public abstract void visitConcreteElementA(ConcreteElementA element);

  public abstract void visitConcreteElementB(ConcreteElementB element);
}
