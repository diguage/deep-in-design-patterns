package com.diguage.didp.proxy;

/**
 * @author D瓜哥, https://www.diguage.com/
 * @since 2017-05-16
 */
public class Proxy extends Subject {
  private Subject realSubject;

  public Proxy(Subject realSubject) {
    this.realSubject = realSubject;
  }

  @Override
  public void request() {
    System.out.println("使用代理开始请求…");
    realSubject.request();
  }
}
