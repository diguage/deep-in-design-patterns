package com.diguage.didp.builder;

/**
 * Director 类
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2017-05-19 17:53:33
 */
public class Director {
  public void construct(Builder builder) {
    builder.buildPartA();
    builder.buildPartB();
  }
}
