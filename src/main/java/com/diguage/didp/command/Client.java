package com.diguage.didp.command;

/**
 * Client 类
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2017-05-19 17:53:34
 */
public class Client {
  public static void main(String[] args) {
    Receiver receiver = new Receiver();
    Command command = new ConcreteCommand(receiver);
    Invoker invoker = new Invoker();
    invoker.setCommand(command);
    invoker.executeCommand();
  }
}
