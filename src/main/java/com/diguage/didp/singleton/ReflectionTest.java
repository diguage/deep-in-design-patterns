package com.diguage.didp.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 反射测试
 *
 * @author diguage
 * @since 16/11/2016.
 */
public class ReflectionTest {
  public static void main(String[] args)
      throws NoSuchMethodException, IllegalAccessException, InvocationTargetException,
          InstantiationException {
    testReflection(CorrectSerializableLazySingleton.getInstance());
    //    testReflection(Singleton.INSTANCE);
  }

  private static <T> void testReflection(T t)
      throws NoSuchMethodException, InstantiationException, IllegalAccessException,
          InvocationTargetException {
    Class<?> clazz = t.getClass();
    Class<?>[] params = {};
    Constructor<?> constructor = clazz.getDeclaredConstructor(params);
    constructor.setAccessible(true);
    T instance = (T) constructor.newInstance();
    System.out.println((instance == t) + "\t:\t" + clazz.getCanonicalName());
  }
}
