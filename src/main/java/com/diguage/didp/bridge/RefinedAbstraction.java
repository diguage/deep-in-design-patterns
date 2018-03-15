package com.diguage.didp.bridge;

/**
 * RefinedAbstraction 类
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2017-05-19 17:53:33
 */
public class RefinedAbstraction extends Abstraction {
  @Override
  public void operation() {
    implementor.operationImpl();
  }
}
