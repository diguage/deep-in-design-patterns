package com.diguage.didp.singleton;

/**
 * 懒汉式单例类
 *
 * <p>Coder：D瓜哥，https://www.diguage.com/
 *
 * <p>Date：2014-5-26.
 */
public class LazySingleton {
  private static LazySingleton instance = null;

  private LazySingleton() {}

  public static LazySingleton getInstance() {
    if (null == instance) {
      synchronized (LazySingleton.class) {
        if (null == instance) {
          instance = new LazySingleton();
        }
      }
    }
    return instance;
  }
}
