package com.study.thread02;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author LiuYang
 * @Date 2020/5/9/009  16:44
 * @Version 1.0
 * 演示线程转储显示锁信息的示例程序
 **/
public class ExplictLockInfo {

  private static final Lock lock=new ReentrantLock();
  private static int sharedData=0;

  public static void main(String[] args) throws Exception {
    Thread t=new Thread(()->{
        lock.lock();
        try {
          Thread.sleep(220000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        } finally {
          lock.unlock();
        }
      });

    t.start();
    Thread.sleep(100);

    lock.lock();
    try {
      System.out.println("sharedData:"+sharedData);
    }finally {
      lock.unlock();
    }
  }
}
