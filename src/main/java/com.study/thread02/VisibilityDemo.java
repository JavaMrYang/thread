package com.study.thread02;

import java.util.Random;

/**
 * @Author LiuYang
 * @Date 2020/5/3/003  11:56
 * @Version 1.0
 * 可见性demo
 **/
public class VisibilityDemo {

  public static void main(String[] args) throws InterruptedException {
      TimeConsumingTask timeConsumingTask=new TimeConsumingTask();
      Thread thread=new Thread(timeConsumingTask);
      thread.start();

      //指定的时间内任务没有执行结束的话，就将它取消
      Thread.sleep(10000);
      timeConsumingTask.cancel();
  }
}

class TimeConsumingTask implements Runnable{
  private boolean toCancel=false;

  @Override
  public void run() {
    while (!toCancel){
        if(doExecute()){
          break;
        }
    }
    if(toCancel){
      System.out.println("Task was canceled");
    }else{
      System.out.println("Task done.");
    }

  }

  private boolean doExecute(){
    boolean isDone=false;
    System.out.println("executing ...");

    //模拟线程实际操作时间消耗
    try {
      Thread.sleep(new Random().nextInt(5)*10);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return isDone;
  }

  public void cancel(){
    toCancel=true;
    System.out.println(this+" canceled.");
  }
}
