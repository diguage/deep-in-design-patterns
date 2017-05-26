package com.diguage.didp.command;

/**
 * Command 类
 *
 * @author D瓜哥，http://www.diguage.com/
 * @since 2017-05-19 17:53:34
 */
public abstract class Command {
  protected Receiver receiver;

  public Command(Receiver receiver) {
    this.receiver = receiver;
  }

  public abstract void execute();
}
