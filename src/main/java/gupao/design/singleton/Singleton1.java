package gupao.design.singleton;

import java.io.Serializable;


/*
懒汉式----当调用getInstance方法是才实例化
* 静态方法中实现的逻辑需要分配内存，也是在调用时才分配的,也就是只有在调用getInstance方法的时候 INSTANCE才会被实例化
* 但是这样会存在线程安全问题：
* 第一个线程 返现 INSTANCE 为null，进入 if语句并准备创建对象
* 此时 第二个线程也判断INSTANCE 为null 进入if语句并创建对象
* 这样就导致实例化了两个对象
* */
public class Singleton1 implements Serializable {
    private static Singleton1 INSTANCE=null;
    private Singleton1(){};
    public static Singleton1 getInstance(){
        if (INSTANCE==null){
            INSTANCE = new Singleton1();
        }
        return  INSTANCE;
    }
}
