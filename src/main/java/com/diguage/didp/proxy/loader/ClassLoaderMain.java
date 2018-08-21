package com.diguage.didp.proxy.loader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassLoaderMain {
  public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
    String progClass = "com.diguage.didp.proxy.asm.Account";

    ProxyClassLoader classLoader = new ProxyClassLoader(Thread.currentThread().getContextClassLoader());
    Class clazz = classLoader.loadClass(progClass);
    Object instance = clazz.newInstance();
    Method operation = clazz.getMethod("operation");
    operation.invoke(instance);

    Method getById = clazz.getMethod("getById", int.class);
    getById.invoke(instance, 123);
  }
}
