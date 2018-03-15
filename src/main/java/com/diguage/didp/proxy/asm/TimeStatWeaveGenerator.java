package com.diguage.didp.proxy.asm;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * @author D瓜哥, https://www.diguage.com/
 * @since 2016-11-17 23:26
 */
public class TimeStatWeaveGenerator {
  public static void main(String[] args) throws IOException, URISyntaxException {
    // 如何实现编制指点类？通过配置文件来获得！
    String className = Account.class.getName();
    ClassReader cr = new ClassReader(className);
    ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
    TimeStatClassAdapter classAdapter = new TimeStatClassAdapter(cw);
    cr.accept(classAdapter, ClassReader.SKIP_DEBUG);
    byte[] data = cw.toByteArray();
    URL url =
        Account.class.getClassLoader().getResource(className.replaceAll("\\.", "/") + ".class");
    System.out.println(url);
    System.out.println(
        "file:/Users/diguage/Documents/wiki.diguage.com/java/deep-in-design-patterns/target/classes/com/diguage/didp/proxy/asm/Account.class");
    //    File file = new File(url.replaceFirst("file:/", "file:///"));
    File file = new File(url.toURI());
    System.out.println(file.exists());
    if (!file.exists()) {
      System.out.println("Create：" + file.createNewFile());
    }
    System.out.println(file.isFile());
    System.out.println(file.canWrite());
    FileOutputStream fout = new FileOutputStream(file);
    fout.write(data);
    fout.close();
  }
}




