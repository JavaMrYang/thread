package com.study.thread02;

/**
 * @Author LiuYang
 * @Date 2020/5/9/009  18:07
 * @Version 1.0
 **/
public class ClassLazyInitDemo {

  public static void main(String[] args) {
    System.out.println(Collaborator.class.hashCode());
    System.out.println(Collaborator.number);
    System.out.println(Collaborator.flag);
  }

  static class Collaborator{
    static int number=1;
    static boolean flag=true;
    static {
      System.out.println("Collaborator initializing...");
    }

  }
}
