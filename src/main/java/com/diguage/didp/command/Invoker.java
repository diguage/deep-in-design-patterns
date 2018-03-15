package com.diguage.didp.command;

/**
 * Invoker 类
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2017-05-19 17:53:34
 */
public class Invoker {
  private Command command;

  public void setCommand(Command command) {
    this.command = command;
  }

  public void executeCommand() {
    command.execute();
  }
}
