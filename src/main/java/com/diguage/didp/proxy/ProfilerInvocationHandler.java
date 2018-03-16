package com.diguage.didp.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author D瓜哥, https://www.diguage.com/
 * @since 2016-11-16
 */
public class ProfilerInvocationHandler implements InvocationHandler {
  private Object realObject;

  public ProfilerInvocationHandler(Object realObject) {
    this.realObject = realObject;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.printf("Profiler======\n%s\n", method.getName());
    long start = System.currentTimeMillis();
    Object result = method.invoke(realObject, args);
    long time = System.currentTimeMillis() - start;
    System.out.println("耗时: " + time);
    System.out.println("Profiler======");
    return result;
  }
}
