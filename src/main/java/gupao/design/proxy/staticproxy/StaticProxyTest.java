package gupao.design.proxy.staticproxy;


/*
* 代理模式可以在不修改被代理对象的基础上，通过扩展代理类，进行一些功能的附加和增强，值的注意的是代理类和被代理类应该共同实现同一个接口，或者是共同继承某个类
* */
public class StaticProxyTest {
    public static  void main(String args[]){
        RealMovie realMovie=new RealMovie(); //电影的真正实现
        Movie movie = new Cinema(realMovie); //电影院实现了movie接口 并且添加自己特有的方法，即电影院是电影的代理
        movie.play();
    }
}
