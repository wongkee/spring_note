package design.proxy.staticproxy;

public class StaticProxyTest {
    public static  void main(String args[]){
        RealMovie realMovie=new RealMovie(); //电影的真正实现
        Movie movie = new Cinema(realMovie); //电影院实现了movie接口 并且添加自己特有的方法，即电影院是电影的代理
        movie.play();
    }
}
