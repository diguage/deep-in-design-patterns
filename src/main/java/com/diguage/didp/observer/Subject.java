package com.diguage.didp.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Subject 类
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2017-05-19 17:53:35
 */
public abstract class Subject {
  private List<Observer> observers = new ArrayList<>();

  public void attach(Observer observer) {
    observers.add(observer);
  }

  public void detach(Observer observer) {
    observers.remove(observer);
  }

  public void doNotify() {
    observers.forEach(Observer::update);
  }
}
