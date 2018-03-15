package com.diguage.didp.facade;

/**
 * Client 类
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2017-05-19 17:53:34
 */
public class Client {
  public static void main(String[] args) {
    Facade facade = new Facade();
    facade.methodA();
    facade.methodB();
  }
}
