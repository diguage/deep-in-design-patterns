package com.diguage.didp.memento;

/**
 * Caretaker 类
 *
 * @author D瓜哥，http://www.diguage.com/
 * @since 2017-05-19 17:53:35
 */
public class Caretaker {
  private Memento memento;

  public Memento getMemento() {
    return memento;
  }

  public void setMemento(Memento memento) {
    this.memento = memento;
  }
}
