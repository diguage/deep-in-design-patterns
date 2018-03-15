package com.diguage.didp.singleton;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 序列化测试
 *
 * @author D瓜哥，https://www.diguage.com/
 * @since 16/11/2016.
 */
public class SerializationTest {
  public static void main(String[] args) throws IOException, ClassNotFoundException {

    testSerialization(SerializableLazySingleton.getInstance());
    testSerialization(CorrectSerializableLazySingleton.getInstance());
    testSerialization(Singleton.INSTANCE);
  }

  public static <T> void testSerialization(T t) throws IOException, ClassNotFoundException {
    // 将对象写入数组中
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(baos);
    oos.writeObject(t);
    baos.close();

    byte[] objectByteArray = baos.toByteArray();

    // 从数组中读取对象
    ByteArrayInputStream bais = new ByteArrayInputStream(objectByteArray);
    ObjectInputStream ois = new ObjectInputStream(bais);
    T newInstance = (T) ois.readObject();
    //判断是否是同一个对象
    Class<?> clazz = t.getClass();
    String canonicalName = clazz.getCanonicalName();
    System.out.println(canonicalName + ": " + (newInstance == t));
  }
}
