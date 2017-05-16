package com.diguage.didp.proxy;

/**
 * 代理类
 *
 * @author D瓜哥，http://www.diguage.com/
 * @since 2017-05-16
 */
public class Client {
  public static void main(String[] args) {
    Proxy proxy = new Proxy(new RealSubject());
    proxy.request();
  }
}
