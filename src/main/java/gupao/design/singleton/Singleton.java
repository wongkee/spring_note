package gupao.design.singleton;

import java.io.Serializable;



/*
* 饿汉式 -----即上来直接就给实例化
* 静态方法和属性在类加载的时候就实例化，即使用不到它也会被实例化
* 类加载到JVM中过程
从上往下（必须声明在前，使用在后）
先属性后方法
先静态、后动态
不管class有没有实例化 static静态块会在classLoader执行完之后，就加载完毕
静态快中的内容只能放置静态属性和静态方法
静态方法中实现的逻辑需要分配内存，也是在调用时才分配的
* */
public class Singleton implements Serializable{
    private static  Singleton INSTANCE=new Singleton();
    private Singleton(){}
    public static Singleton getInstance(){
        return INSTANCE;
    }
}
