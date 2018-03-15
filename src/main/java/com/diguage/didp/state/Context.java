package com.diguage.didp.state;

/**
 * Context 类
 *
 * @author D瓜哥，https://www.diguage.com/
 * @since 2017-05-19 17:53:36
 */
public class Context {
  private State state;

  public Context(State state) {
    this.state = state;
  }

  public State getState() {
    return state;
  }

  public void setState(State state) {
    this.state = state;
    System.out.println("当前状态：" + state.getClass().getName());
  }

  public void request() {
    state.handle(this);
  }
}
