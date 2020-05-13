package com.study.thread02;

import com.study.util.Tools;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author LiuYang
 * @Date 2020/5/9/009  18:13
 * @Version 1.0
 **/

public class StaticVisibilityExample {
  private static Map<String,String> taskConfig;
  static {
    System.out.println("The class being initialized...");
    taskConfig=new HashMap<>();
    taskConfig.put("url","https://github.com/Visent");
    taskConfig.put("timeout","1000");
  }

  public static void changConfig(String url,int timeout){
    taskConfig=new HashMap<>();
    taskConfig.put("url",url);
    taskConfig.put("timeout",String.valueOf(timeout));
  }

  public static void init(){
    Thread t=new Thread(){
      @Override
      public void run() {
        String url=taskConfig.get("url");
        String timeout=taskConfig.get("timeout");
        doTask(url,Integer.valueOf(timeout));
      }
    };
    t.start();
  }

  public static void doTask(String url,int timeout){
    Tools.randomPause(500);
  }

  public static void main(String[] args) {
    new StaticVisibilityExample();
  }
}
