package com.diguage.didp.singleton;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 单例模式并发性测试
 *
 * @author D瓜哥，https://www.diguage.com/
 * @since 16/11/2016.
 */
public class ConcurrentTest {
  public static void main(String[] args) {
    int THREAD_COUNT = 10000;
    CountDownLatch latch = new CountDownLatch(THREAD_COUNT);
    ConcurrentMap concurrentMap = new ConcurrentHashMap();
    ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
    for (int i = 0; i < THREAD_COUNT; i++) {
      executorService.execute(new SingletonFactory(latch, concurrentMap, i));
      latch.countDown();
    }
    executorService.shutdown();
  }
}

class SingletonFactory implements Runnable {
  private CountDownLatch latch;
  private ConcurrentMap concurrentMap;
  private int id;

  public SingletonFactory(CountDownLatch latch, ConcurrentMap concurrentMap, int id) {
    this.latch = latch;
    this.concurrentMap = concurrentMap;
    this.id = id;
  }

  public void run() {
    try {
      latch.await();
      LazySingleton instance = LazySingleton.getInstance();
      concurrentMap.put(instance, instance);
      System.out.println(id + "\t" + concurrentMap.size());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
