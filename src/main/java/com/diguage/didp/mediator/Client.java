package com.diguage.didp.mediator;

/**
 * @author D瓜哥, https://www.diguage.com/
 * @since 2017-05-26
 */
public class Client {
  public static void main(String[] args) {
    ConcreteMediator mediator = new ConcreteMediator();

    ConcreteColleague1 colleague1 = new ConcreteColleague1(mediator);
    ConcreteColleague2 colleague2 = new ConcreteColleague2(mediator);

    mediator.setColleague1(colleague1);
    mediator.setColleague2(colleague2);

    colleague1.send("吃过饭了吗？");
    colleague2.send("没有呢，你打算请客？");
  }
}
