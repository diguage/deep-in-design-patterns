package com.diguage.didp.proxy.loader;


import com.diguage.didp.proxy.asm.ProfilerClassAdapter;
import com.diguage.didp.proxy.bytebuddy.ProfilerInterceptor;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.pool.TypePool;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author D瓜哥, https://www.diguage.com/
 * @since 2018-03-23
 */
public class ProxyClassLoader extends ClassLoader {
  public ProxyClassLoader(ClassLoader parent) {
    super(parent);
  }

  /**
   * @param className 全限定名的类目, 例如 com.diguage.Foo
   */
  private Class getClass(String className) throws ClassNotFoundException {
    String file = className.replace('.', File.separatorChar) + ".class";
    byte[] classByteArray = null;
    try {
      // TODO 在这里做手脚
//      ClassReader cr = new ClassReader(className);
//      ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
//      ProfilerClassAdapter classAdapter = new ProfilerClassAdapter(cw);
//      cr.accept(classAdapter, ClassReader.SKIP_DEBUG);
//      classByteArray = cw.toByteArray();

      ClassFileLocator classFileLocator = ClassFileLocator.ForClassLoader.of(Thread.currentThread().getContextClassLoader());
      TypePool typePool = TypePool.Default.ofSystemLoader();
//
      classByteArray = new ByteBuddy()
          .rebase(typePool.describe(className).resolve(), classFileLocator)
          .method(ElementMatchers.any())
          .intercept(MethodDelegation.to(ProfilerInterceptor.class))
          .make()
          .getBytes();



//      Class<? extends DynamicType.Unloaded> clazz = new ByteBuddy()
//          .rebase()
//          .rebase(Object.class)
//          .method(ElementMatchers.any())
//          .intercept(MethodDelegation.to(ProfilerInterceptor.class))
//          .make().getClass();
      Class clazz = defineClass(className, classByteArray, 0, classByteArray.length);
      resolveClass(clazz);
      return clazz;
    } catch (Throwable e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * @param name 全限定名的类名
   */
  @Override
  public Class loadClass(String name) throws ClassNotFoundException {
    System.out.println("Loading Class '" + name + "'");
    if (name.startsWith("com.diguage.didp.proxy.asm.Account") && !name.contains("$")) {
      System.out.println("Loading Class using ProxyClassLoader");
      return getClass(name);
    }
    return super.loadClass(name);
  }

  /**
   * @param name 全限定名的类名
   * @return 文件的字节数组
   * @throws IOException
   */
  private byte[] loadClassFileData(String name) throws IOException {
    InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(name);
    int size = stream.available();
    byte buff[] = new byte[size];
    DataInputStream in = new DataInputStream(stream);
    in.readFully(buff);
    in.close();
    return buff;
  }
}
