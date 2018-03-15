package com.diguage.didp.singleton;

import java.io.Serializable;

/**
 * 可以序列化的懒汉式单例类
 *
 * <p>注：不正确
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2014-5-26.
 */
public class SerializableLazySingleton implements Serializable {
  private static volatile SerializableLazySingleton instance = null;

  private SerializableLazySingleton() {}

  public static SerializableLazySingleton getInstance() {
    if (null == instance) {
      synchronized (SerializableLazySingleton.class) {
        if (null == instance) {
          instance = new SerializableLazySingleton();
        }
      }
    }
    return instance;
  }
}
