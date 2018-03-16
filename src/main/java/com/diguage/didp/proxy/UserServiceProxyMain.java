package com.diguage.didp.proxy;

/**
 * @author D瓜哥, https://www.diguage.com/
 * @since 16/11/2016.
 */
public class UserServiceProxyMain {
  public static void main(String[] args) {
    UserService userService = new UserServiceImpl();
    UserService proxy = new UserServiceAuthenticationProxy(userService);
    System.out.println(proxy.getById(123));
  }
}
