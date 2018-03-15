package com.diguage.didp.observer;

/**
 * ConcreteObserver 类
 *
 * @author D瓜哥，https://www.diguage.com/
 * @since 2017-05-19 17:53:35
 */
public class ConcreteObserver implements Observer {
  private String name;
  private String observerState;
  private ConcreteSubject subject;

  public ConcreteObserver(ConcreteSubject subject, String name) {
    this.name = name;
    this.subject = subject;
  }

  @Override
  public void update() {
    observerState = subject.getSubjectState();
    System.out.printf("观察者 %s 的新状态是 %s%n", name, observerState);
  }

  public ConcreteSubject getSubject() {
    return subject;
  }

  public void setSubject(ConcreteSubject subject) {
    this.subject = subject;
  }
}
