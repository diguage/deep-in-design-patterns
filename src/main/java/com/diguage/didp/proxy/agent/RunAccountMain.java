package com.diguage.didp.proxy.agent;

import com.diguage.didp.proxy.asm.Account;

/**
 * @author D瓜哥，https://www.diguage.com/
 * @since 2016-11-18 14:41
 */
public class RunAccountMain {
  public static void main(String[] args) {
    Account account = new Account();
    System.out.println(account.getById(789));
    System.out.println(account.operation());
  }
}
