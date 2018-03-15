package com.diguage.didp.state;

/**
 * ConcreteStateC 类
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2017-05-19 17:53:36
 */
public class ConcreteStateC extends State {
  @Override
  public void handle(Context context) {
    context.setState(new ConcreteStateA());
  }
}
