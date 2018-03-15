package com.diguage.didp.flyweight;

/**
 * Client 类
 *
 * @author D瓜哥，https://www.diguage.com/
 * @since 2017-05-19 17:53:35
 */
public class Client {
  public static void main(String[] args) {
    int extrinsticState = 22;
    FlyweightFactory factory = new FlyweightFactory();

    FlyWeight fx = factory.getFlyWeight("X");
    fx.operation(--extrinsticState);

    FlyWeight fy = factory.getFlyWeight("Y");
    fy.operation(--extrinsticState);

    FlyWeight fz = factory.getFlyWeight("Z");
    fz.operation(--extrinsticState);

    UnsharedConcreteFlyWeight uf = new UnsharedConcreteFlyWeight();
    uf.operation(--extrinsticState);
  }
}
