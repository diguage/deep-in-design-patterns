package com.diguage.didp.strategy;

/**
 * Client 类
 *
 * @author D瓜哥，https://www.diguage.com/
 * @since 2017-05-16
 */
public class Client {
  public static void main(String[] args) {
    Context context = new Context(new ConcreteStrategyA());
    context.contextInterface();

    context.setStrategy(new ConcreteStrategyB());
    context.contextInterface();

    context.setStrategy(new ConcreteStrategyC());
    context.contextInterface();
  }
}
