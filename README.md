# thread 多线程的创建和使用指南
线程的创建方式
 1.继承Thread类 参考ThreadCreate01

2.实现runnable方法 参考ThreadCreate02

3.实现callable接口，通过funtureTask拿到结果 参考ThreadCreate03

根据处理对两个不同方式实现的线程对Counter类的局部变量进行相加，看看效果 参考ThreadCreationCmp

其中直接调用run方法，不会运行自身线程，而是使用的主线程 参考ThreadStart

简易定时器 SimpleTimer

