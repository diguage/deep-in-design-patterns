package com.diguage.didp.bridge;

/**
 * Abstraction 类
 *
 * @author D瓜哥，http://www.diguage.com/
 * @since 2017-05-19 17:53:33
 */
public abstract class Abstraction {
  protected Implementor implementor;

  public void setImplementor(Implementor implementor) {
    this.implementor = implementor;
  }

  public void operation() {
    implementor.operationImpl();
  }
}
