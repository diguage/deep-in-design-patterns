package com.diguage.didp.mediator;

/**
 * Colleague 类
 *
 * @author D瓜哥，https://www.diguage.com/
 * @since 2017-05-19 17:53:35
 */
public abstract class Colleague {
  protected Mediator mediator;

  public Colleague(Mediator mediator) {
    this.mediator = mediator;
  }

  public abstract void notify(String message);

  public void send(String message) {
    mediator.send(message, this);
  }
}
