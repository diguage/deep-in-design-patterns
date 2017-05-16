package com.diguage.didp.strategy;

/**
 * Context 类
 *
 * @author diguage
 * @since 2017-05-16
 */
public class Context {
  private Strategy strategy;

  public Context(Strategy strategy) {
    this.strategy = strategy;
  }

  public void contextInterface() {
    strategy.algorithmInterface();
  }
}
class  Context
