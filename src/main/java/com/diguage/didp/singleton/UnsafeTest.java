package com.diguage.didp.singleton;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * {@link Unsafe} 创建实例测试
 *
 * @author diguage
 * @since 16/11/2016.
 */
public class UnsafeTest {
  public static void main(String[] args)
      throws NoSuchFieldException, IllegalAccessException, InstantiationException {
    testUnsafe(CorrectSerializableLazySingleton.getInstance());
    testUnsafe(Singleton.INSTANCE);
  }

  private static <T> void testUnsafe(T t)
      throws NoSuchFieldException, IllegalAccessException, InstantiationException {
    Unsafe unsafe = getUnsafe();
    Class<?> clazz = t.getClass();
    T instance = (T) unsafe.allocateInstance(clazz);
    System.out.println((instance == t) + "\t:\t" + clazz.getCanonicalName());
  }

  private static Unsafe getUnsafe() throws NoSuchFieldException, IllegalAccessException {
    // 通过反射得到theUnsafe对应的Field对象
    Field field = Unsafe.class.getDeclaredField("theUnsafe");
    // 设置该Field为可访问
    field.setAccessible(true);
    // 通过Field得到该Field对应的具体对象，传入null是因为该Field为static的
    return (Unsafe) field.get(null);
  }
}
