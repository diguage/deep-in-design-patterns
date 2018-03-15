package com.diguage.didp.facade;

/**
 * Facade 类
 *
 * @author D瓜哥，https://www.diguage.com/
 * @since 2017-05-19 17:53:34
 */
public class Facade {
  private SubSystemOne systemOne;
  private SubSystemTwo systemTwo;
  private SubSystemThree systemThree;
  private SubSystemFour systemFour;

  public Facade() {
    systemOne = new SubSystemOne();
    systemTwo = new SubSystemTwo();
    systemThree = new SubSystemThree();
    systemFour = new SubSystemFour();
  }

  public void methodA() {
    System.out.println("方法A() ---");
    systemOne.methodOne();
    systemTwo.methodTwo();
  }

  public void methodB() {
    System.out.println("方法B() ---");
    systemFour.methodFour();
    systemThree.methodThree();
  }
}
