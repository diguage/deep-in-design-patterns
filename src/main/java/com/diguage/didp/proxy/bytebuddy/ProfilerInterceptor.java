package com.diguage.didp.proxy.bytebuddy;

import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.SuperCall;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/**
 * @author D瓜哥, https://www.diguage.com/
 * @since 2018-03-16
 */
public class ProfilerInterceptor {
  @RuntimeType
  public static Object intercept(@Origin Method method,
                                 @SuperCall Callable<?> callable) {
    long start = System.currentTimeMillis();
    try {
      return callable.call();
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e.getMessage(), e);
    } finally {
      System.out.println(method + " took " + (System.currentTimeMillis() - start) + "\n\n");
    }
  }
}
