package com.diguage.didp.mediator;

/**
 * ConcreteColleague1 类
 *
 * @author D瓜哥，http://www.diguage.com/
 * @since 2017-05-23 09:09:49
 */
public class ConcreteColleague1 extends Colleague {
  public ConcreteColleague1(Mediator mediator) {
    super(mediator);
  }

  @Override
  public void notify(String message) {
    System.out.println("同事1得到消息：" + message);
  }
}
