package com.diguage.didp.interpreter;

/**
 * TerminalExpression 类
 *
 * @author D瓜哥，https://www.diguage.com/
 * @since 2017-05-19 17:53:35
 */
public class TerminalExpression extends AbstractExpression {
  @Override
  public void interpret(Context context) {
    System.out.println("终端解释器！");
  }
}
