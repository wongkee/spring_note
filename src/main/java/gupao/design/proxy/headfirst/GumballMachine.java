package gupao.design.proxy.headfirst;

public class GumballMachine {
    String location;
    int count;
    public GumballMachine(String location,int count){
        this.location=location;
        this.count=count;
    }

    public String getLocation() {
        return location;
    }
    public int getCount(){
        return count;
    }
}
