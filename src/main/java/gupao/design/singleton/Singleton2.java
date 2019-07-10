package gupao.design.singleton;


import java.io.Serializable;


/*
* 为了解决懒汉式线程不安全问题，为getInstance方法加锁
* 缺点效率太低
* */
public class Singleton2 implements Serializable {
    private static Singleton2 instance =null;
    private Singleton2(){}
    public  static synchronized Singleton2 getInstance(){
       /*
       * 静态方法中智能引用静态属性
       * */
       if(instance==null){
           instance=new Singleton2();
       }
        return instance;
    }
}
