package com.diguage.didp.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * Product 类
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2017-05-19 17:53:33
 */
public class Product {
  List<String> parts = new ArrayList<String>();

  public void add(String part) {
    parts.add(part);
  }

  public void show() {
    System.out.println("产品创建---");
    parts.forEach(System.out::println);
  }
}
