package com.diguage.didp.templatemethod;

/**
 * AbstractClass 类
 *
 * @author D瓜哥，http://www.diguage.com/
 * @since 2017-05-19 17:53:36
 */
public abstract class AbstractClass {
  public final void templateMethod() {
    primitiveOperation1();
    System.out.println("这是模板方法！");
    primitiveOperation2();
  }

  public abstract void primitiveOperation1();

  public abstract void primitiveOperation2();
}
