package com.diguage.didp.proxy;

import java.lang.reflect.Proxy;

/**
 * @author D瓜哥, https://www.diguage.com/
 * @since 16/11/2016.
 */
public class DynamicProxyMain {
  public static void main(String[] args) {
    UserService userService = new UserServiceImpl();
    PerformanceInvocationHandler handler = new PerformanceInvocationHandler(userService);
    UserService proxyInstance =
        (UserService)
            Proxy.newProxyInstance(
                UserService.class.getClassLoader(), UserServiceImpl.class.getInterfaces(), handler);
    System.out.println(proxyInstance.getById(345));
  }
}
