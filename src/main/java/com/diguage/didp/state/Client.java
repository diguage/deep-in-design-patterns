package com.diguage.didp.state;

/**
 * @author diguage
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
