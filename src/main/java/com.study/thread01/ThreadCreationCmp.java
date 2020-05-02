package com.study.thread01;


/**
 * @Author LiuYang
 * @Date 2020/5/2/002  13:56
 * @Version 1.0
 * 创建两个线程对一个Counter静态类进行加1，加一百次，看看什么效果
 **/
public class ThreadCreationCmp {

  public static void main(String[] args) {
    Thread thread;
    CountingTask task=new CountingTask();

    //获取处理器个数
    final int numberOfprocess=Runtime.getRuntime().availableProcessors();

    for(int i=0;i<2*numberOfprocess;i++){
      //直接创建线程
      thread=new Thread(task);
      thread.start();
    }
    for(int i=0;i<2*numberOfprocess;i++){
      //以子类的方式创建线程
      thread=new CountingThread();
      thread.start();
    }
  }

  static class Counter{
    private int counter=0;

    public void  increment(){
      counter++;
    }
    public int value(){
      return counter;
    }
  }

  static class CountingTask implements Runnable{
    private Counter counter=new Counter();

    @Override
    public void run() {
      for(int i=0;i<100;i++){
        doSomething();
        counter.increment();
      }
      System.out.println("CountingTask:"+counter.value());
    }

    private void doSomething() {
      try {
        Thread.sleep(80);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  static class  CountingThread extends Thread{
    private Counter counter=new Counter();
    @Override
    public void run() {
      for(int i=0;i<100;i++){
        doSomething();
        counter.increment();
      }
      System.out.println("CountingThread:"+counter.value());
    }
    private void doSomething() {
      try {
        Thread.sleep(80);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
