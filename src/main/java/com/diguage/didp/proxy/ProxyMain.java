package com.diguage.didp.proxy;

/**
 * @author diguage
 * @since 16/11/2016.
 */
public class ProxyMain {
  public static void main(String[] args) {
    UserService userService = new UserServiceImpl();
    UserService proxy = new UserServiceProxy(userService);
    System.out.println(proxy.getById(123));
  }
}