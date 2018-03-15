package com.diguage.didp.proxy.asm;

/**
 * @author D瓜哥, https://www.diguage.com/
 * @since 2016-11-17 23:47
 */
public class RunTimeMainAfterGen {
  public static void main(String[] args) {
    Account account = new Account();
    System.out.println(account.operation());
    // 可以通过传递不同的数字来观察耗时统计，
    // 来检验是否修改过字节码……
    System.out.println(account.getById(2345));
    System.out.println(account.toString());
  }
}
