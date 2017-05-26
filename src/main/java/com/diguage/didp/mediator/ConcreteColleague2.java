package com.diguage.didp.mediator;

/**
 * ConcreteColleague2 类
 *
 * @author D瓜哥，http://www.diguage.com/
 * @since 2017-05-23 09:09:49
 */
public class ConcreteColleague2 extends Colleague {
  public ConcreteColleague2(Mediator mediator) {
    super(mediator);
  }

  @Override
  public void notify(String message) {
    System.out.println("同事2得到消息：" + message);
  }
}
