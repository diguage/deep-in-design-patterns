package com.diguage.didp.proxy;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author D瓜哥，https://www.diguage.com/
 * @since 16/11/2016.
 */
public class UserServiceImpl implements UserService {
  public String getById(int id) {
    try {
      TimeUnit.MILLISECONDS.sleep(new Random().nextInt(1000));
    } catch (InterruptedException e) {
    }
    return "User-" + id;
  }
}
