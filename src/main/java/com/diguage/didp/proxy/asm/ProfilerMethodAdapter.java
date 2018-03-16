package com.diguage.didp.proxy.asm;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * @author D瓜哥, https://www.diguage.com/
 * @since 2016-11-18 10:15
 */
public class ProfilerMethodAdapter extends MethodVisitor implements Opcodes {

  public ProfilerMethodAdapter(MethodVisitor mv) {
    super(Opcodes.ASM5, mv);
  }

  @Override
  public void visitCode() {
    visitMethodInsn(Opcodes.INVOKESTATIC, "com/diguage/didp/proxy/asm/Profiler", "start", "()V");
    super.visitCode();
  }

  @Override
  public void visitInsn(int opcode) {
    if (opcode >= IRETURN && opcode <= RETURN) {
      visitMethodInsn(Opcodes.INVOKESTATIC, "com/diguage/didp/proxy/asm/Profiler", "end", "()V");
    }
    mv.visitInsn(opcode);
  }
}
