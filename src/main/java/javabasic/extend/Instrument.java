package javabasic.extend;

public class Instrument {
    public void play(){
        System.out.println("I am play");
    }
    static void tune(Instrument i){
        i.play();
    }
}
