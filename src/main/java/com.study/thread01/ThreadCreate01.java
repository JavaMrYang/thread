package com.study.thread01;

/**
 * @Author LiuYang
 * @Date 2020/5/2/002  13:18
 * @Version 1.0
 * 多线程创建方式一，继承Thread类
 **/
public class ThreadCreate01 {

  public static void main(String[] args) {
    //创建线程
    Thread thread=new WecomeThread();
    //启动线程
    thread.start();
    //输出"当前线程的名称"
    System.out.printf("1.Welcome! I'm %s.%n",Thread.currentThread().getName());
  }

  /**
   * 定义Thread的子类
   */
  private static class WecomeThread extends Thread{

    @Override
    public void run() {
      System.out.printf("2.Welcome! I'm %s.%n",Thread.currentThread().getName());
    }
  }
}
