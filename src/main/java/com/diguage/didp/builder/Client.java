package com.diguage.didp.builder;

/**
 * @author D瓜哥，http://www.diguage.com/
 * @since 2017-05-25 21:00:03
 */
public class Client {
  public static void main(String[] args) {
    Director director = new Director();
    Builder builder = new ConcreteBuilder();
    director.construct(builder);
    Product product = builder.getResult();
    product.show();
  }
}
