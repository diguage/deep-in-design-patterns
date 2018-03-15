package com.diguage.didp.chainofresponsibility;

import java.util.Arrays;

/**
 * Client 类
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2017-05-19 17:53:33
 */
public class Client {
  public static void main(String[] args) {
    Handler h1 = new ConcreteHandler1();
    Handler h2 = new ConcreteHandler2();
    Handler h3 = new ConcreteHandler3();
    h1.setSuccessor(h2);
    h2.setSuccessor(h3);

    int[] requests = new int[]{1, 2, 3, 5, 8, 13, 21};
    Arrays.stream(requests).forEach(h1::handleRequest);
  }
}
