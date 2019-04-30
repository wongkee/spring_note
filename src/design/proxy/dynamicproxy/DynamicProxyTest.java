package design.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
//参考https://blog.csdn.net/briblue/article/details/73928350
public class DynamicProxyTest {
    public static void main(String[] args){
        MaotaiJiu maotaiJiu=new MaotaiJiu();
        InvocationHandler jingxiao1=new GuitaiA(maotaiJiu);//向上转型
        SellWine dynamicProxy=(SellWine) Proxy.newProxyInstance(MaotaiJiu.class.getClassLoader(),MaotaiJiu.class.getInterfaces(),jingxiao1);
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
