package com.diguage.didp.interpreter;

import java.util.ArrayList;
import java.util.List;

/**
 * Client 类
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2017-05-19 17:53:35
 */
public class Client {
  public static void main(String[] args) {
    Context context = new Context();
    List<AbstractExpression> expressions = new ArrayList<>();
    expressions.add(new TerminalExpression());
    expressions.add(new NonterminalExpression());
    expressions.add(new TerminalExpression());
    expressions.add(new TerminalExpression());

    expressions.forEach(e -> e.interpret(context));
  }
}
