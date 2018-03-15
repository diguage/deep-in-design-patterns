package com.diguage.didp.proxy;

/**
 * Client 类
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2017-05-16
 */
public class Client {
  public static void main(String[] args) {
    Subject subject = new Proxy(new RealSubject());
    subject.request();
  }
}
