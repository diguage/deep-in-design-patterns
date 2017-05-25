package com.diguage.didp.builder;

/**
 * ConcreteBuilder 类
 *
 * @author D瓜哥，http://www.diguage.com/
 * @since 2017-05-19 17:53:33
 */
public class ConcreteBuilder extends Builder {
  private Product product = new Product();

  @Override
  public void buildPartA() {
    product.add("部件A");
  }

  @Override
  public void buildPartB() {
    product.add("部件B");
  }

  @Override
  public Product getResult() {
    return product;
  }
}
