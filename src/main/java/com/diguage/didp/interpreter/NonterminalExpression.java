package com.diguage.didp.interpreter;

/**
 * NonterminalExpression 类
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2017-05-19 17:53:35
 */
public class NonterminalExpression extends AbstractExpression {
  @Override
  public void interpret(Context context) {
    System.out.println("非终端解释器！");
  }
}
