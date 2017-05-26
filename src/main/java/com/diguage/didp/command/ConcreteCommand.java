package com.diguage.didp.command;

/**
 * ConcreteCommand 类
 *
 * @author D瓜哥，http://www.diguage.com/
 * @since 2017-05-19 17:53:34
 */
public class ConcreteCommand extends Command {
  public ConcreteCommand(Receiver receiver) {
    super(receiver);
  }

  public void execute() {
    receiver.action();
  }
}
