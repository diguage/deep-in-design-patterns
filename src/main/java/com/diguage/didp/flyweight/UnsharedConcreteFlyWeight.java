package com.diguage.didp.flyweight;

/**
 * UnsharedConcreteFlyWeight 类
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2017-05-23 09:09:48
 */
public class UnsharedConcreteFlyWeight extends FlyWeight {
  @Override
  public void operation(int extrinsticState) {
    System.out.println("不共享的具体 FlyWeight：" + extrinsticState);
  }
}
