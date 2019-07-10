package gupao.design.singleton;

import java.io.Serializable;

/*
* 使用内部类的方式，推荐使用
* 看上去与饿汉式相似，但是不同之处就在于，它把对象实例化放在内部类中，只有在调用getInstance()方法是才会装载SingletonHoleder类从而完成对象的实例化
* 好处：
* 1、类的静态属性只会在第一次加载类的时候初始化
* 2、JVM帮助我们保证了线程的安全性，在类的初始化时，别的线程是无法进入的
* */
public class Singleton4 implements Serializable {
    private Singleton4(){}
    private static class  SingletonHolder{
        private static final Singleton4 instance=new Singleton4();
    }
    public static Singleton4 getInstance(){
        return SingletonHolder.instance;
    }
}
