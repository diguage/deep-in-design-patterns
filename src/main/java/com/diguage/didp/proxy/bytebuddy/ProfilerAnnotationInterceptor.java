package com.diguage.didp.proxy.bytebuddy;

import net.bytebuddy.asm.Advice;

/**
 * @author D瓜哥, https://www.diguage.com/
 * @since 2018-03-15
 */
public class ProfilerAnnotationInterceptor {
  public static ThreadLocal<Long> threadLocal = new ThreadLocal();

  @Advice.OnMethodEnter
  public static void enter(@Advice.Origin("#t.#m") String signature) {
    System.out.printf("Enter: %s\n", signature);
    long start = System.currentTimeMillis();
    threadLocal.set(start);
  }

  @Advice.OnMethodExit
  public static void exit(@Advice.Origin("#t.#m") String signature) {
    long value = System.currentTimeMillis() - threadLocal.get();
    System.out.printf("Exit: %s\nTime: %d\n\n", signature, value);
  }
}
