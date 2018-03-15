package com.diguage.didp.iterator;

/**
 * Client 类
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2017-05-19 17:53:35
 */
public class Client {
  public static void main(String[] args) {
    ConcreteAggregate aggregate = new ConcreteAggregate();
    int i = 0;
    aggregate.set(i++, "大鸟");
    aggregate.set(i++, "小菜");
    aggregate.set(i++, "行李");
    aggregate.set(i++, "老外");
    aggregate.set(i++, "公交内部员工");
    aggregate.set(i++, "小偷");

    Iterator iterator = new ConcreteIterator(aggregate);
    Object first = iterator.first();
    while (!iterator.isDone()) {
      System.out.printf("%s 请买车票！", iterator.currentItem());
      iterator.next();
    }
  }
}
