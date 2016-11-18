package com.diguage.didp.proxy.asm;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author D瓜哥，http://www.diguage.com/
 * @since 2016-11-17 23:19
 */
public class Account {
  public int operation() {
    System.out.println("operation……");
    int timeout = new Random().nextInt(1000);
    try {
      TimeUnit.MILLISECONDS.sleep(timeout);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return timeout;
  }

  public String getById(int id) {
    System.out.println("getById……");
    try {
      TimeUnit.MILLISECONDS.sleep(new Random().nextInt(1000));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return "Account-" + id;
  }
}
