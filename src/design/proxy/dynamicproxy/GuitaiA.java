package design.proxy.dynamicproxy;

import javafx.beans.binding.ObjectExpression;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

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
