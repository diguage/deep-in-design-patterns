package com.diguage.didp.mediator;

/**
 * ConcreteMediator 类
 *
 * @author D瓜哥，https://www.diguage.com/
 * @since 2017-05-23 09:09:49
 */
public class ConcreteMediator extends Mediator {
  private ConcreteColleague1 colleague1;
  private ConcreteColleague2 colleague2;

  public void setColleague1(ConcreteColleague1 colleague1) {
    this.colleague1 = colleague1;
  }

  public void setColleague2(ConcreteColleague2 colleague2) {
    this.colleague2 = colleague2;
  }

  @Override
  public void send(String message, Colleague colleague) {
    if (colleague == colleague1) {
      colleague2.notify(message);
    } else {
      colleague1.notify(message);
    }
  }
}
