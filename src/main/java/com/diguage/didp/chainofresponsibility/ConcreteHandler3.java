package com.diguage.didp.chainofresponsibility;

/**
 * ConcreteHandler2 类
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2017-05-19 17:53:33
 */
public class ConcreteHandler3 extends Handler {
  @Override
  public void handleRequest(int request) {
    if (request >= 20 && request < 30) {
      System.out.printf("%s 处理 %s%n", this.getClass().getName(), request);
    } else if (successor != null) {
      successor.handleRequest(request);
    }
  }
}
