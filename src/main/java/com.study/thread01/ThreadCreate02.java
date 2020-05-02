package com.study.thread01;

/**
 * @Author LiuYang
 * @Date 2020/5/2/002  13:26
 * @Version 1.0
 * Runable实现线程
 **/
public class ThreadCreate02 {

  public static void main(String[] args) {
    Thread thread=new Thread(new RunaleThread());
    thread.start();
    //输出"当前线程的名称"
    System.out.printf("1.Welcome! I'm %s.%n",Thread.currentThread().getName());
  }
}

class RunaleThread implements Runnable{

  public void run() {
    System.out.printf("2.Welcome! I'm %s.%n",Thread.currentThread().getName());
  }
}
