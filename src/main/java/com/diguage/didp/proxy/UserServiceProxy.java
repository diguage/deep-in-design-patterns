package com.diguage.didp.proxy;

/**
 * @author D瓜哥，https://www.diguage.com/
 * @since 16/11/2016.
 */
public class UserServiceProxy implements UserService {
  UserService userService;

  public UserServiceProxy(UserService userService) {
    this.userService = userService;
  }

  public String getById(int id) {
    return userService.getById(id);
  }
}
