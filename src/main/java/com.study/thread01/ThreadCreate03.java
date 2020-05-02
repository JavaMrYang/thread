package com.study.thread01;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author LiuYang
 * @Date 2020/5/2/002  13:42
 * @Version 1.0
 **/
public class ThreadCreate03 {

  public static void main(String[] args) {
    FutureTask task=new FutureTask<>(new ThreadCall());
    Thread thread=new Thread(task);
    thread.start();
    try {
      while (!task.isDone()){
        Thread.sleep(500);
      }
      String result= (String) task.get();
      System.out.printf("我获取的结果是:%s .%n",result);
      System.out.printf("1.Welcome! I'm %s.%n",Thread.currentThread().getName());
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      e.printStackTrace();
    }

  }
  static class ThreadCall implements Callable<String>{

    @Override
    public String call() throws Exception {
      String result="hh";
      System.out.printf("我%s是通过callabel创建的,我返回的值是%s.%n",Thread.currentThread().getName(),result);
      return result;
    }
  }
}
