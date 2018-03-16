package com.diguage.didp.proxy.bytebuddy;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;

/**
 * @author D瓜哥, https://www.diguage.com/
 * @since 2018-03-15 19:17:38
 */
public class ProflierAnnotationAgent {
  public static void premain(String agentArgs, Instrumentation instrumentation) {
    System.out.println("Premain started");
    try {
      new AgentBuilder.Default()
//        .with(AgentBuilder.Listener.StreamWriting.toSystemOut()) // Debug
          .with(AgentBuilder.TypeStrategy.Default.REBASE)
//        .type((typeDescription, classLoader, javaModule, aClass, protectionDomain) -> true)
          .type(ElementMatchers.any())
          .transform((builder, typeDescription, classLoader, javaModule) ->
              builder.visit(Advice.to(ProfilerAnnotationInterceptor.class).on(ElementMatchers.any())))
          .installOn(instrumentation);
    } catch (RuntimeException e) {
      System.out.println("Exception instrumenting code : " + e);
      e.printStackTrace();
    }
  }
}
