package com.study.thread02;

import com.study.util.Tools;

/**
 * @Author LiuYang
 * @Date 2020/5/9/009  21:56
 * @Version 1.0
 **/
public class RaceConditionDemo {

  public static void main(String[] args) {
    //客户端线程数
    int numberOfThreads=args.length>0?Short.valueOf(args[0]):Runtime.getRuntime()
        .availableProcessors();
    Thread[] workThreads=new Thread[numberOfThreads];
    for(int i=0;i<workThreads.length;i++){
        workThreads[i]=new WorkThread(i,10);
    }

    // 待所有线程创建完毕后，再一次性将其启动，以便这些线程能够尽可能地在同一时间内运行
    for (Thread ct : workThreads) {
      ct.start();
    }
  }

  static class WorkThread extends Thread{
    private int requestCount=0;

    public WorkThread(int id,int requestCount){
      super("worker-" + id);
      this.requestCount = requestCount;
    }

    @Override
    public void run() {
      int i = requestCount;
      String requestID;
      RequestIDGenerator requestIDGen = RequestIDGenerator.getInstance();
      while (i-- > 0) {
        // 生成Request ID
        requestID = requestIDGen.nextID();
        processRequest(requestID);
      }
    }

    // 模拟请求处理
    private void processRequest(String requestID) {
      // 模拟请求处理耗时
      Tools.randomPause(50);
      System.out.printf("%s got requestID: %s %n",
          Thread.currentThread().getName(), requestID);
    }
  }
}
