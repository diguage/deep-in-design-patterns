package com.diguage.didp.memento;

/**
 * Originator 类
 *
 * @author D瓜哥，http://www.diguage.com/
 * @since 2017-05-19 17:53:35
 */
public class Originator {
  private String state;

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public void setMemento(Memento memento) {
    state = memento.getState();
  }

  public Memento createMemento() {
    return new Memento(state);
  }

  public void show() {
    System.out.println("State=" + state);
  }
}
