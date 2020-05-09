package com.study.thread02;

import com.study.util.stf.ConcurrencyTest;
import com.study.util.stf.Expect;
import com.study.util.stf.Observer;
import com.study.util.stf.TestRunner;

/**
 * @Author LiuYang
 * @Date 2020/5/9/009  14:36
 * @Version 1.0
 * 再现JIT指令重排序的Demo
 **/
@ConcurrencyTest(iterations = 200000)
public class JITReorderingDemo {

  private int externalData=1;
  private Helper helpler;

  public void createHelper(){
    this.helpler=new Helper(externalData);
  }

  @Observer({
      @Expect(desc = "helper is null",expected = -1),
      @Expect(desc = "helper is not null,but is not initialized",expected = 0),
      @Expect(desc = "Only 1 field of Helper instance was initialized",expected = 1),
      @Expect(desc = "Only 2 field of Helper instance was initialized",expected = 2),
      @Expect(desc = "Only 3 field of Helper instance was initialized",expected = 3),
  })
  public int consume(){

    int sum=0;
    /**
     * 由于我们未对共享变量helper进行任何处理(比如采用volatile关键字修饰变量)
     * 因此，这里可能存在可见性问题，即当前线程读取到的变量值可能为null
     */
    final Helper observedHelper=helpler;
    if(null==observedHelper){
      sum=-1;
    }else{
      sum=observedHelper.payloadA+observedHelper.payloadB
          +observedHelper.payloadC+observedHelper.payloadC;
    }
    return sum;
  }

  public static void main(String[] args) throws IllegalAccessException, InstantiationException {
    TestRunner.runTest(JITReorderingDemo.class);
  }

  static class Helper{
    int payloadA;
    int payloadB;
    int payloadC;
    int payloadD;

    public Helper(int externalData) {
      this.payloadA = externalData;
      this.payloadB = externalData;
      this.payloadC = externalData;
      this.payloadD = externalData;
    }
  }
}
