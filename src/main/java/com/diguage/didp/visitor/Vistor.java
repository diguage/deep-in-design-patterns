package com.diguage.didp.visitor;

/**
 * Vistor 类
 *
 * @author D瓜哥，http://www.diguage.com/
 * @since 2017-05-19 17:53:36
 */
public abstract class Vistor {
  public abstract visitConcreteElementA(ConcreteElementA element);
  public abstract visitConcreteElementB(ConcreteElementB element);
}
