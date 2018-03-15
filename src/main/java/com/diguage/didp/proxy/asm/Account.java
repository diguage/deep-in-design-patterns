package com.diguage.didp.proxy.asm;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author D瓜哥, https://www.diguage.com/
 * @since 2016-11-17 23:19
 */
public class Account {
  public int operation() {
    System.out.println("operation……");
    int timeout = new Random().nextInt(1000);
    try {
      TimeUnit.MILLISECONDS.sleep(timeout + 1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return timeout;
  }

  public String getById(int id) {
    System.out.println("getById……");
    try {
      // 以参数传递过来的数字来决定休眠时间，
      // 来检验实际效果
      TimeUnit.MILLISECONDS.sleep(id);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return "Account-" + id;
  }

  public static void main(String[] args) {
    Account account = new Account();
    account.operation();
    account.getById(123);
  }
}
