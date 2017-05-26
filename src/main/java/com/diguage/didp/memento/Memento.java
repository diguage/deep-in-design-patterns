package com.diguage.didp.memento;

/**
 * Memento 类
 *
 * @author D瓜哥，http://www.diguage.com/
 * @since 2017-05-19 17:53:35
 */
public class Memento {
  private String state;

  public Memento(String state) {
    this.state = state;
  }

  public String getState() {
    return state;
  }
}
