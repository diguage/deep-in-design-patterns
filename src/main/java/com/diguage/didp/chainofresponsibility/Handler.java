package com.diguage.didp.chainofresponsibility;

/**
 * Handler 类
 *
 * @author D瓜哥，http://www.diguage.com/
 * @since 2017-05-19 17:53:33
 */
public abstract class Handler {
  protected Handler successor;

  public void setSuccessor(Handler successor) {
    this.successor = successor;
  }

  public abstract void handleRequest(int request);
}
