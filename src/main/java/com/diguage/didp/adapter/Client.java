package com.diguage.didp.adapter;

/**
 * Client 类
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2017-05-19 17:53:33
 */
public class Client {
  public static void main(String[] args) {
    Target target = new Adapter();
    target.request();
  }
}
