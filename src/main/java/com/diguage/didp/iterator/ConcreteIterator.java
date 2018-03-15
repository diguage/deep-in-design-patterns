package com.diguage.didp.iterator;

/**
 * ConcreteIterator 类
 *
 * @author D瓜哥，https://www.diguage.com/
 * @since 2017-05-23 09:09:49
 */
public class ConcreteIterator extends Iterator {
  private ConcreteAggregate aggregate;
  private int current = 0;

  public ConcreteIterator(ConcreteAggregate aggregate) {
    this.aggregate = aggregate;
  }

  @Override
  public Object first() {
    return aggregate.get(0);
  }

  @Override
  public Object next() {
    Object ret = null;
    current++;
    if (current < aggregate.count()) {
      ret = aggregate.get(current);
    }
    return ret;
  }

  @Override
  public boolean isDone() {
    return current >= aggregate.count();
  }

  @Override
  public Object currentItem() {
    return aggregate.get(current);
  }
}
