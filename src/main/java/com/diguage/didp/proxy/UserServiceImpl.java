package com.diguage.didp.proxy;

import java.util.concurrent.TimeUnit;

/**
 * @author D瓜哥, https://www.diguage.com/
 * @since 16/11/2016.
 */
public class UserServiceImpl implements UserService {
  @Override
  public String getById(int id) {
    try {
      System.out.println("真是请求：根据ID获取对应用户…");
      TimeUnit.MILLISECONDS.sleep(id);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return "User-" + id;
  }
}
