package com.diguage.didp.observer;

/**
 * @author D瓜哥，https://www.diguage.com/
 * @since 2017-05-25 21:19:03
 */
public class Client {
  public static void main(String[] args) {
    ConcreteSubject subject = new ConcreteSubject();
    subject.attach(new ConcreteObserver(subject, "X"));
    subject.attach(new ConcreteObserver(subject, "Y"));
    subject.attach(new ConcreteObserver(subject, "Z"));
    subject.setSubjectState("ABC");
    subject.doNotify();
  }
}
