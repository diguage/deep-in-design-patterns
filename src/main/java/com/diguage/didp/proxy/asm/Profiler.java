package com.diguage.didp.proxy.asm;

/**
 * @author D瓜哥, https://www.diguage.com/
 * @since 2016-11-17 23:22
 */
public class Profiler {
  static ThreadLocal<Long> t = new ThreadLocal<Long>();

  public static void start() {
    t.set(System.currentTimeMillis());
  }

  public static void end() {
    long time = System.currentTimeMillis() - t.get();
    System.out.print(Thread.currentThread().getStackTrace()[2] + " speed:");
    System.out.println(time);
  }
}
