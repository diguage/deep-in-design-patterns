package com.diguage.didp.singleton;

import java.io.Serializable;

/**
 * 可以序列化的懒汉式单例类
 *
 * @author D瓜哥，https://www.diguage.com/
 * @since 2014-5-26.
 */
public class CorrectSerializableLazySingleton implements Serializable {

  private static volatile CorrectSerializableLazySingleton instance = null;

  private CorrectSerializableLazySingleton() {}

  public static CorrectSerializableLazySingleton getInstance() {
    if (null == instance) {
      synchronized (CorrectSerializableLazySingleton.class) {
        if (null == instance) {
          instance = new CorrectSerializableLazySingleton();
        }
      }
    }
    return instance;
  }

  private Object readResolve() {
    return instance;
  }
}
