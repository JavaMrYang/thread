package com.study.thread02;

import com.study.util.Tools;

/**
 * @Author LiuYang
 * @Date 2020/5/3/003  17:33
 * @Version 1.0
 **/
public class ThreadStartVisibility {
  //线程间的共享变量
  static int data=0;

  public static void main(String[] args) {
    Thread thread=new Thread(){
      @Override
      public void run() {
        //使线程休眠R毫秒 （R为随机数）
        Tools.randomPause(50);

        //读取并打印data变量的值
        System.out.println(data);
      }
    };
    //在子线程thread启动前更新data的值
    data=1;
    thread.start();

    Tools.randomPause(50);

    //在子线程启动后更新变量data的值
    data=2;
  }
}
