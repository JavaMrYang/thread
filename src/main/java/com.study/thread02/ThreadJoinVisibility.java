package com.study.thread02;

import com.study.util.Tools;

/**
 * @Author LiuYang
 * @Date 2020/5/3/003  17:48
 * @Version 1.0
 **/
public class ThreadJoinVisibility {

  //线程间的共享变量
  static int data=0;

  public static void main(String[] args) {
    Thread thread=new Thread(){
      @Override
      public void run() {
        Tools.randomPause(50);

        data=1;
      }
    };

    thread.start();

    try {
      thread.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    //读取并打印data变量的值
    System.out.println(data);
  }
}
