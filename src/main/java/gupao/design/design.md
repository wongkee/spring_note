### 设计模式
#### 代理模式
代理：代理可以通过Internet为他们的代理对象搬运整个方法嗲用，也可以代替某些懒惰的对象做一些事情。  


静态代理  
动态代理  
    动态代理与静态代理的区别就是可以让程序在运行的时候自动在内存中创建一个Movie接口的代理，而不需要定义Cinema这个类。这就是它被称为动态的原因  
headfirst包中是headfirt设计模式一书中对该设计模式的实现  

远程代理（headfirst设计模式）  
需求提出：对糖果机有很好的监控，找一种方法给CEO一份库存和机器状态报告。  
解决方法：
创建一个GumballMonitor 对糖果机进行监控，并将报告打印出来      
创建一个糖果机类 GumballMachine,它记录自己的位置和自己的生产状态  
将被监控的机器实例传递给 GumballMonitor,将其信息打印出来  


需求变更：  
需要的是远程监控糖果机，上面的实现都是在同一个JVM虚拟机中...  
解决方法
不变化GumballMonitor,不将糖果机交给GumballMonitor,而是将一个远程对象的代理交给它。  
原理如图：
 ![](remoteproxy)
 java内置的远程调用功能，RMI  
 原理：  
 rmi.jpg  
 
 实现步骤：
 1、制作远程接口；定义出可以让客户远程调用的方法。Stub和实际的服务都实现此接口
 2、制作远程实现： 实际工作的类，为远程接口中定义的远程方法提供真正的实现。这就是客户真正想要调用方法的对象
 3、利用rmic产生的stub和skeleton；  客户和服务的辅助类。工具自动生成（注此步骤在jdk8中已经被抛弃，不再使用rmic静态生成）
 4、启动RMI registry： 就像电话博，客户可以从中查到代理的位置
 5、开启远程服务； 服务类实例化一个服务对象，并将这个服务注册到RMI registry。之后服务就可以供客户调用了
 
实现原理
rmi-2.gif


java.security.AccessControlException: access denied.... 权限问题的错误  
解决方案  jdk\jre\lib\security\java.policy  
grant{} 最后一行添加  
permission java.security.AllPermission;  
参考博客：https://blog.csdn.net/qq_14994863/article/details/80769487  
继而报错：
java.rmi.ServerException: RemoteException occurred in server thread; nested exception is: 
	java.rmi.UnmarshalException: error unmarshalling arguments; nested exception is: 
解决方法 在class文件、bin目录下、当前类所在文件夹某一个下（这个真的是不确定，我是在classes文件夹）下执行rmiregistry  
然后再打开服务端  
开启客户端进行测试  
代码地址 spring_note\src\main\java\gupao\design\proxy\headfirst\rmitutor

