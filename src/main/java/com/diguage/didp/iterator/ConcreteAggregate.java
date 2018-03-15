package com.diguage.didp.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * ConcreteAggregate 类
 *
 * @author D瓜哥，https://www.diguage.com/
 * @since 2017-05-19 17:53:35
 */
public class ConcreteAggregate extends Aggregate {
  private List<Object> items = new ArrayList<>();

  public Iterator createIterator() {
    return new ConcreteIterator(this);
  }

  public Object get(int index) {
    return items.get(index);
  }

  public void set(int index, Object item) {
    items.set(index, item);
  }

  public int count() {
    return items.size();
  }
}
