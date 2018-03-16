package com.diguage.didp.proxy;

/**
 * @author D瓜哥, https://www.diguage.com/
 * @since 16/11/2016.
 */
public class UserServiceAuthenticationProxy implements UserService {
  UserService userService;

  public UserServiceAuthenticationProxy(UserService userService) {
    this.userService = userService;
  }

  @Override
  public String getById(int id) {
    if (id < 1000) {
      System.out.println("非特权用户，禁止访问……");
      return null;
    }
    return userService.getById(id);
  }
}
