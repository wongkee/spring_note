package javabasic.extend;

public class Wind extends  Instrument {
    public void mylpay(){
        System.out.println("myplay...");
    }
    public static void main(String args[]){
        Wind flute=new Wind();
        flute.mylpay();
        Instrument.tune(flute);

        Instrument instrument=new Wind();
        instrument.play();
      //  instrument.myplay(); 无法使用


    }
}
