package com.diguage.didp.proxy.bytebuddy;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;

/**
 * @author D瓜哥, https://www.diguage.com/
 * @since 2018-03-16
 */
public class ProflierAgent {
  public static void premain(String arguments,
                             Instrumentation instrumentation) {
    new AgentBuilder.Default()
        .type(ElementMatchers.any())
        .transform((builder, type, classLoader, module) ->
            builder.method(ElementMatchers.any())
                .intercept(MethodDelegation.to(ProfilerInterceptor.class))
        ).installOn(instrumentation);
  }
}
