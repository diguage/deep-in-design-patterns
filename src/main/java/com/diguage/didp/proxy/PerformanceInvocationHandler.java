package com.diguage.didp.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/** Created by diguage on 16/11/2016. */
public class PerformanceInvocationHandler implements InvocationHandler {
  private Object realObject;

  public PerformanceInvocationHandler(Object realObject) {
    this.realObject = realObject;
  }

  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    long start = System.currentTimeMillis();
    Object result = method.invoke(realObject, args);
    long time = System.currentTimeMillis() - start;
    System.out.println("time: " + time);
    return result;
  }
}
