package gupao.design.singleton;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

public class SingletonTest {
    public static void main(String[] args){
        /*
        * 使用 ==比较 比较的是两个对象是否处于同一块内存，即 比较的是地址
        * */
        Singleton s1=Singleton.getInstance();
        Singleton s2=Singleton.getInstance();
        if(s1==s2){
            System.out.println("s1==s2");
        }else {
            System.out.println("s1!=s2");
        } //output: s1==s2


        Singleton1 s11=Singleton1.getInstance();
        Singleton1 s12=Singleton1.getInstance();
        if(s11==s12){
            System.out.println("s11==s12");//s11==s12
        }else {
            System.out.println("s11!=s12");
        }

        Singleton2 s21=Singleton2.getInstance();
        Singleton2 s22=Singleton2.getInstance();
        if(s21==s22){
            System.out.println("s21==s22");//s21==s22
        }else {
            System.out.println("s11!=s12");
        }

        Singleton3 s31=Singleton3.getInstance();
        Singleton3 s32=Singleton3.getInstance();
        if(s31==s32){
            System.out.println("s31==s32"); //s31==s32
        }else {
            System.out.println("s31!=s32");
        }


        Singleton4 s41=Singleton4.getInstance();
        Singleton4 s42=Singleton4.getInstance();
        if(s41==s42){
            System.out.println("s41==s42");////s41==s42
        }else {
            System.out.println("s41!=s42");
        }


        /*
        * 使用多线程进行测试
        * */
        int count=5000;
        CountDownLatch latch=new CountDownLatch(count);
        final Set<Singleton1> syncSet= Collections.synchronizedSet(new HashSet<Singleton1>());
        for (int i=0;i<count;i++){
            new Thread(){
                public void run(){
                    syncSet.add(Singleton1.getInstance());
                }
            }.start();
            latch.countDown();
        }

        try{
            latch.await();
            System.out.println(syncSet.size());  //output: 1  一般比较不出来结果
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//要注意 java反射机制里面要使用全类名
        SpringSingleton springSingleton=SpringSingleton.getInstance("gupao.design.singleton.SpringSingleton");
        SpringSingleton springSingleton1=SpringSingleton.getInstance("gupao.design.singleton.SpringSingleton");

        if(springSingleton==springSingleton1){
            System.out.println("springSingleton==springSinglrton1");
        }else {
            System.out.println("springSingleton!=springSinglrton1");
        }

    }
}
