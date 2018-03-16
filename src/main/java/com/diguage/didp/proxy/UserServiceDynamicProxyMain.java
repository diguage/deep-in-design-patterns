package com.diguage.didp.proxy;

import java.lang.reflect.Proxy;

/**
 * @author D瓜哥, https://www.diguage.com/
 * @since 16/11/2016.
 */
public class UserServiceDynamicProxyMain {
  public static void main(String[] args) {
    UserService userService = new UserServiceImpl();

    ClassLoader classLoader = UserService.class.getClassLoader();
    Class<?>[] interfaces = UserServiceImpl.class.getInterfaces();

    UserService profilerInstance =
        (UserService)
            Proxy.newProxyInstance(
                classLoader,
                interfaces,
                new ProfilerInvocationHandler(userService));

    UserService logProfilerInstance =
        (UserService)
            Proxy.newProxyInstance(
                classLoader,
                interfaces,
                new LoggerInvocationHandler(profilerInstance));

    System.out.println("最终结果：" + logProfilerInstance.getById(345));

    Subject subject = (Subject) Proxy.newProxyInstance(
        RealSubject.class.getClassLoader(),
        RealSubject.class.getInterfaces(),
        new LoggerInvocationHandler(new RealSubject()));
    subject.request();
  }

//  public static <T> T newProxyInstance(ClassLoader classLoader,
//                                       InvocationHandler handler, T... t) {
//    return (T) Proxy.newProxyInstance(classLoader, t.getClass(), handler);
//  }
}
