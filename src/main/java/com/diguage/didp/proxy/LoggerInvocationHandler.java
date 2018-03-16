package com.diguage.didp.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author D瓜哥, https://www.diguage.com/
 * @since 2018-03-16
 */
public class LoggerInvocationHandler implements InvocationHandler {
  private Object realObject;

  public LoggerInvocationHandler(Object realObject) {
    this.realObject = realObject;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.printf("Logger------\nMethod: %s\n", method.getName());
    if (args != null && args.length > 0) {
      System.out.println("Params:");
      for (Object arg : args) {
          System.out.println(arg);
      }
    }
    Object result = method.invoke(realObject, args);
    System.out.println("Logger------");
    return result;
  }
}
