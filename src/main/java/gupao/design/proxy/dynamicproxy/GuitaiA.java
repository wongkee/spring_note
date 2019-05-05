package gupao.design.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


//实现这个接口表明其为一个代理
public class GuitaiA implements InvocationHandler {
   private Object pingtai;
   public  GuitaiA(Object pingtai){
       this.pingtai=pingtai;
   }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("销售开始 柜台是："+this.getClass().getSimpleName());
        method.invoke(pingtai,args);
        System.out.println("销售结束");
        return null;
    }
}
