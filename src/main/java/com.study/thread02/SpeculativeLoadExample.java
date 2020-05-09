package com.study.thread02;

/**
 * @Author LiuYang
 * @Date 2020/5/9/009  15:13
 * @Version 1.0
 **/
public class SpeculativeLoadExample {

  private boolean ready=false;
  private  int[] data=new int[]{1,2,3,4,5,6,7,8};

  public void writer(){
    int[] newData=new int[]{1,2,3,4,5,6,7,8};
    for(int i=0;i<newData.length;i++){

      //此处包含读内存操作
      newData[i]=newData[i]-1;
    }
    data=newData;
    ready=true;
  }

  public int reader(){
    int sum=0;
    int[] snapshot;
    if(ready){
      snapshot=data;
      for(int i=0;i<snapshot.length;i++){
        sum+=snapshot[i];
      }
    }
    return sum;
  }

}
