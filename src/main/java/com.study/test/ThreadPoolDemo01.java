package com.study.test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author LiuYang
 * @Date 2020/5/16/016  13:11
 * @Version 1.0
 **/
public class ThreadPoolDemo01 {
  private static ThreadPoolParam threadPoolParam;
  static {
    threadPoolParam=new ThreadPoolParam(5,10,1000,new ArrayBlockingQueue(1000));
  }

  public static void main(String[] args) {
    ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(threadPoolParam.coreSize,
        threadPoolParam.maxPoolSize,threadPoolParam.keepTime, TimeUnit.SECONDS,
        threadPoolParam.arrayBlockingQueue);
    Map map=new HashMap();
    map.put("name","张三");
    for(int i=0;i<3;i++){
      threadPoolExecutor.execute(new ThreadTask(map));
    }
    map.put("age",12);
    threadPoolExecutor.execute(new ThreadTask(map));
    //threadPoolExecutor.
  }

  public static class ThreadPoolParam{
    private int coreSize;
    private int maxPoolSize;
    private long keepTime;
    private ArrayBlockingQueue arrayBlockingQueue;

    public ThreadPoolParam(int coreSize, int maxPoolSize, long keepTime,
        ArrayBlockingQueue arrayBlockingQueue) {
      this.coreSize = coreSize;
      this.maxPoolSize = maxPoolSize;
      this.keepTime = keepTime;
      this.arrayBlockingQueue = arrayBlockingQueue;
    }
  }

}
