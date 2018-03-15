package com.diguage.didp.proxy;

/**
 * @author D瓜哥, https://www.diguage.com/
 * @since 16/11/2016.
 */
public class UserServiceProxy implements UserService {
  UserService userService;

  public UserServiceProxy(UserService userService) {
    this.userService = userService;
  }

  @Override
  public String getById(int id) {
    System.out.println("使用代理请求…");
    return userService.getById(id);
  }
}
