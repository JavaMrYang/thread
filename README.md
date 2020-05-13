# thread 多线程的创建和使用指南
线程的创建方式
 1.继承Thread类 参考ThreadCreate01

2.实现runnable方法 参考ThreadCreate02

3.实现callable接口，通过funtureTask拿到结果 参考ThreadCreate03

根据处理对两个不同方式实现的线程对Counter类的局部变量进行相加，看看效果 参考ThreadCreationCmp

其中直接调用run方法，不会运行自身线程，而是使用的主线程 参考ThreadStart

简易定时器 SimpleTimer


对线程类的理解
线程本身包括四个属性，分别是id、name、daemon、priority，分别指线程id号（唯一)
name(Thread_+id号)，daemon是否是守护线程，priority线程优先级

线程方法:
1.start 启动线程
2.run 实际线程运行的线程
3.yield 主动放弃当前线程对处理器的占用，可能导致当前线程的暂停
4.join 等待相应线程的运行结束
5.sleep 睡眠当前线程到指定时间



多线程场景的几大特点:
1.无序性 多个线程启动，顺序可能不一致
2.原子性 多个线程对一个局部变量的读取，更新，写入操作不可分割，可能不一致
3.可见性  多个线程对共享变量的值可能不一致 参考VisibilityDemo

处理器札记：处理器并不是直接与主内存（ram）打交道而执行内存的读、写操作，而是通过寄存器、高速缓存、写缓冲器和无效化队列等部件执行
内存的读、写操作。

线程锁：参考 (doc/thread_lock.md)



