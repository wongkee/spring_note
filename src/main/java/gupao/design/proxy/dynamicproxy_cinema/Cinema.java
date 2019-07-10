package gupao.design.proxy.dynamicproxy_cinema;

import gupao.design.proxy.dynamicproxy_cinema.RealMovie;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Cinema implements InvocationHandler {
    private  Object target;
    public Object getInstance(Object target){
        this.target=target;
        Class clazz=target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("电影马上开始了，爆米花、可乐、口香糖..");
        //this.target.play();
        method.invoke(this.target,args);
        System.out.println("电影马上结束，快回家吧！、、");
        return null;
    }
}
