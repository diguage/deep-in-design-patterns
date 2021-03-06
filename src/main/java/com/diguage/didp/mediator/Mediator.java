package com.diguage.didp.mediator;

/**
 * Mediator 类
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2017-05-19 17:53:35
 */
public abstract class Mediator {
  public abstract void send(String message, Colleague colleague);
}
