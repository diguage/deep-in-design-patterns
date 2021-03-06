package com.diguage.didp.builder;

/**
 * Builder 类
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2017-05-19 17:53:33
 */
public abstract class Builder {
  public abstract void buildPartA();

  public abstract void buildPartB();

  public abstract Product getResult();
}
