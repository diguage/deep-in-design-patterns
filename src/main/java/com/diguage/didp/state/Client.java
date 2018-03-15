package com.diguage.didp.state;

/**
 * @author D瓜哥，https://www.diguage.com/
 * @since 2017-05-26
 */
public class Client {
  public static void main(String[] args) {
    Context context = new Context(new ConcreteStateA());
    context.request();
    context.request();
    context.request();
    context.request();
  }
}
