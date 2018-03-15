package com.diguage.didp.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * FlyweightFactory 类
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2017-05-19 17:53:34
 */
public class FlyweightFactory {
  private Map<String, FlyWeight> flyWeights = new HashMap<>();

  public FlyweightFactory() {
    flyWeights.put("X", new ConcreteFlyWeight());
    flyWeights.put("Y", new ConcreteFlyWeight());
    flyWeights.put("Z", new ConcreteFlyWeight());
  }

  public FlyWeight getFlyWeight(String key) {
    return flyWeights.get(key);
  }
}
