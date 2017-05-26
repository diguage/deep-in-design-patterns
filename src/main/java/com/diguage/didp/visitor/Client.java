package com.diguage.didp.visitor;

/**
 * Client 类
 *
 * @author D瓜哥，http://www.diguage.com/
 * @since 2017-05-19 17:53:36
 */
public class Client {
  public static void main(String[] args) {
    ObjectStructure o = new ObjectStructure();
    o.attach(new ConcreteElementA());
    o.attach(new ConcreteElementB());

    ConcreteVisitor1 v1 = new ConcreteVisitor1();
    ConcreteVisitor2 v2 = new ConcreteVisitor2();

    o.accept(v1);
    o.accept(v2);
  }
}
