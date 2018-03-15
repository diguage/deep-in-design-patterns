package com.diguage.didp.singleton;

/**
 * 饿汉式单例类
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2014-5-26.
 */
public class HungrySingleton {
  private static HungrySingleton instance = new HungrySingleton();

  private HungrySingleton() {}

  public static HungrySingleton getInstance() {
    return instance;
  }
}
