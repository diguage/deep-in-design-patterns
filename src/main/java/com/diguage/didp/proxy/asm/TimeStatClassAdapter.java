package com.diguage.didp.proxy.asm;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * @author D瓜哥, https://www.diguage.com/
 * @since 2016-11-18 10:15
 */
public class TimeStatClassAdapter extends ClassVisitor {
  public TimeStatClassAdapter(ClassVisitor cv) {
    super(Opcodes.ASM5, cv);
  }

  @Override
  public MethodVisitor visitMethod(
          final int access,
          final String name,
          final String desc,
          final String signature,
          final String[] exceptions) {
    MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
    MethodVisitor wrapperMv = mv;
    if (mv != null) {
      // TODO 如何实现只编制指定类下的方法呢？
//      if (name.equals("operation")) {
      wrapperMv = new TimeStatMethodAdapter(mv);
//      }
    }
    return wrapperMv;
  }
}