package gupao.design.proxy.dynamicproxy_cinema;

import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Test {
    public static void main(String[] args){
       RealMovie realMovie=new RealMovie();
        Movie movie=(Movie) new Cinema().getInstance(realMovie);
        System.out.println(movie.getClass()); //output:class com.sun.proxy.$Proxy0
        byte[] data=ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{movie.getClass()});
        FileOutputStream fos=null;
        try {
            fos=new FileOutputStream("E:/$Proxy0.class");
            fos.write(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        movie.play();
    }
}
