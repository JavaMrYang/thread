package com.study.thread01;

/**
 * @Author LiuYang
 * @Date 2020/5/2/002  14:15
 * @Version 1.0
 * 简易倒时计数器
 **/
public class SimpleTimer {
  private static int count=0;
  public static void main(String[] args) {
    count=args.length>=1?Integer.valueOf(args[0]):60;
    int remainning;
    while (true){
      remainning=CountDown();
      if(0==remainning){
        break;
      }else{
        System.out.println("Remainning"+count+" second(s)");
      }

      try {
        Thread.sleep(1000);
      }catch (Exception e){

      }
    }
    System.out.println("done.");
  }

  private static int CountDown() {
    return --count;
  }


}
