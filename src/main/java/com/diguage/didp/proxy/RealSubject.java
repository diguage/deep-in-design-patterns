package com.diguage.didp.proxy;

/**
 * RealSubject 类
 *
 * @author D瓜哥，https://www.diguage.com/
 * @since 2017-05-16
 */
public class RealSubject extends Subject {
  public void request() {
    System.out.println("真是请求！");
  }
}
