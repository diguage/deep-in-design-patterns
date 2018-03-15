package com.diguage.didp.abstractfactory;

/**
 * Client 类
 *
 * @author D瓜哥，https://www.diguage.com/
 * @since 2017-05-19 17:53:33
 */
public class Client {
  private AbstractFactory factory;
  private AbstractProductA productA;
  private AbstractProductB productB;

  private String type;

  public Client(String type) {
    this.type = type;
    if ("A".equals(this.type) || "a".equals(this.type)) {
      factory = new ConcreteFactory1();
    } else {
      factory = new ConcreteFactory2();
    }
    productA = factory.createProductA();
    productB = factory.createProductB();
  }

  public AbstractFactory getFactory() {
    return factory;
  }

  public AbstractProductA getProductA() {
    return productA;
  }

  public AbstractProductB getProductB() {
    return productB;
  }

  public static void main(String[] args) {
    Client client = new Client("a");
    System.out.println(client.getFactory().getClass());
    System.out.println(client.getProductA().getClass());
    System.out.println(client.getProductB().getClass());
  }
}
