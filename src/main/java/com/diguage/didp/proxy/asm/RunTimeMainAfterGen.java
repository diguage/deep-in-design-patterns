package com.diguage.didp.proxy.asm;

/**
 * @author D瓜哥，https://www.diguage.com/
 * @since 2016-11-17 23:47
 */
public class RunTimeMainAfterGen {
  public static void main(String[] args) {
    Account account = new Account();
    System.out.println(account.operation());
    System.out.println(account.getById(345));
    System.out.println(account.toString());
  }
}
