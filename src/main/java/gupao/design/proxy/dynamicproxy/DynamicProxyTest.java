package gupao.design.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
//参考https://blog.csdn.net/briblue/article/details/73928350
/*
* 静态代理需要手动编写代码让 Cinema 实现 Movie 接口，而在动态代理中，我们可以让程序在运行的时候自动在内存中创建一个实现 Movie 接口的代理，而不需要去定义 Cinema 这个类。这就是它被称为动态的原因。
* */
public class DynamicProxyTest {
    public static void main(String[] args){
        MaotaiJiu maotaiJiu=new MaotaiJiu();
        InvocationHandler jingxiao1=new GuitaiA(maotaiJiu);//向上转型
        SellWine dynamicProxy=(SellWine) Proxy.newProxyInstance(MaotaiJiu.class.getClassLoader(),MaotaiJiu.class.getInterfaces(),jingxiao1);
        System.out.println("被代理对象的class是："+dynamicProxy.getClass());//class com.sun.proxy.$Proxy0 动态在内存创建
        /*
        * 原理
        * 1、拿到被代理对象的引用，然后获取它的接口
        * 2、jdk重新生成一个类，同时实现我们给的代理对象所实现的接口
        * 3、把被代理 对象的引用也拿到
        * 4、重新动态生成一个class字节码
        * 5、然后编译
        * */
        dynamicProxy.mainJiu();

        /*
        * public static Object newProxyInstance(ClassLoader loader,
                                          Class<?>[] interfaces,
                                          InvocationHandler h)
            loader 自然是类加载器
            interfaces  代码要用来代理的接口
            h 一个InocationHandler对象
        * */
    }
}
