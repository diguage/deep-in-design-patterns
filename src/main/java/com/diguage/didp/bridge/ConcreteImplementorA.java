package com.diguage.didp.bridge;

/**
 * ConcreteImplementorA 类
 *
 * @author D瓜哥，http://www.diguage.com/
 * @since 2017-05-19 17:53:33
 */
public class ConcreteImplementorA extends Implementor {
  @Override
  public void operationImpl() {
    System.out.println("具体实现A的方法执行！");
  }
}
