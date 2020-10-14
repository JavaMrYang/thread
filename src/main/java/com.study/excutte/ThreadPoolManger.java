package com.study.excutte;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author LiuYang
 * @Date 2020/5/16/016  13:09
 * @Version 1.0
 **/
public class ThreadPoolManger {

  private ThreadPoolExecutor thread;


  public ThreadPoolManger(){
      thread=new ThreadPoolExecutor(5,10,1000,
          TimeUnit.SECONDS,new ArrayBlockingQueue(10));
  }


  public void addTask(Runnable runnable){
    if(runnable!=null){
      thread.execute(runnable);
    }
  }


}
