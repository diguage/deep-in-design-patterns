package com.diguage.didp.proxy.agent;

import com.diguage.didp.proxy.asm.TimeStatClassAdapter;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.lang.instrument.Instrumentation;

/**
 * @author D瓜哥, https://www.diguage.com/
 * @since 2016-11-18 10:21
 */
public class PreMainAddTimeStatAgent {
  public static void premain(String agentArgs, Instrumentation instrumentation) {
    System.out.println("agentArgs: " + agentArgs);
    instrumentation.addTransformer(
        (loader, className, classBeingRedefined, protectionDomain, classfileBuffer) -> {
          if (className.equals("com/diguage/didp/proxy/asm/Account")) {
            System.out.println("meet com.diguage.didp.proxy.asm.Account");
            ClassReader cr = new ClassReader(classfileBuffer);
            ClassWriter cw =
                new ClassWriter(
                    (ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES));
            TimeStatClassAdapter classAdapter = new TimeStatClassAdapter(cw);
            cr.accept(classAdapter, ClassReader.SKIP_DEBUG);
            return cw.toByteArray();
          } else {
            System.out.println("\nload: " + className);
            return classfileBuffer;
          }
        });
  }
}
