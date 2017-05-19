package com.diguage.didp.chainofresponsibility;

/**
 * Handler 类
 *
 * @author D瓜哥，http://www.diguage.com/
 * @since 2017-05-19 17:53:33
 */
public abstract class Handler {
  public void setSuccessor(Handler successor) {
  }
  public abstract Object handleRequest(int request);
}
