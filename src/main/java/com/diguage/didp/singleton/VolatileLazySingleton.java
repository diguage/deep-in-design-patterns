package com.diguage.didp.singleton;

import java.io.Serializable;

/**
 * 带 <code>volatile</code> 修饰的懒汉式单例类
 *
 * @author D瓜哥，http://www.diguage.com/
 * @since 2014-5-26.
 */
public class VolatileLazySingleton implements Serializable {
  private static volatile VolatileLazySingleton instance = null;

  private VolatileLazySingleton() {}

  public static VolatileLazySingleton getInstance() {
    if (null == instance) {
      synchronized (VolatileLazySingleton.class) {
        if (null == instance) {
          instance = new VolatileLazySingleton();
        }
      }
    }
    return instance;
  }
}
