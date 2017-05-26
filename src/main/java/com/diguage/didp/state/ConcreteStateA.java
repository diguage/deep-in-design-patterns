package com.diguage.didp.state;

/**
 * ConcreteStateA 类
 *
 * @author D瓜哥，http://www.diguage.com/
 * @since 2017-05-19 17:53:36
 */
public class ConcreteStateA extends State {
  @Override
  public void handle(Context context) {
    context.setState(new ConcreteStateB());
  }
}
