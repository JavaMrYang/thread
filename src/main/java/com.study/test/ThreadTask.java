package com.study.test;

import java.util.Iterator;
import java.util.Map;

/**
 * @Author LiuYang
 * @Date 2020/5/16/016  13:20
 * @Version 1.0
 **/
public class ThreadTask implements Runnable {

  private Map<String,Object> map;

  public ThreadTask(Map map) {
    this.map = map;
  }

  @Override
  public void run() {
    if(!map.isEmpty()){
      Iterator it=map.keySet().iterator();
      while (it.hasNext()){
        String key=String.valueOf(it.next());
        String val= map.get(key)+"";
        System.out.printf("我获取的参数键：%s,值:%s \n",key,val);
      }
    }

  }
}
