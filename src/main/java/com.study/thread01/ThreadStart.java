package com.study.thread01;

/**
 * @Author LiuYang
 * @Date 2020/5/2/002  13:32
 * @Version 1.0
 **/
public class ThreadStart {

  public static void main(String[] args) {
    //创建线程，匿名内部类创建
    Thread thread=new Thread(()->{
      System.out.printf("2.Welcome! I'm %s.%n",Thread.currentThread().getName());
    });

    thread.start();
    //直接调用run方法
    thread.run();
    //输出"当前线程的名称"
    System.out.printf("1.Welcome! I'm %s.%n",Thread.currentThread().getName());
  }
}
