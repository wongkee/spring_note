package gupao.design.proxy.staticproxy;

public class Cinema implements  Movie {
   RealMovie movie;
    public Cinema(RealMovie movie){
        super();
        this.movie=movie;
    }
    @Override
    public void play() {
        guanggao(true);
        movie.play();
        guanggao(false);
    }
    public void guanggao(boolean isStart){
        if(isStart){
            System.out.println("电影马上开始了，爆米花、可乐、口香糖..");

        }else {
            System.out.println("电影马上结束，快回家吧！、、");
        }
    }
}
