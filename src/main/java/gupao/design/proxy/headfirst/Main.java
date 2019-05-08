package gupao.design.proxy.headfirst;

public class Main {
    public static  void main(String args[]){
        GumballMachine machine=new GumballMachine("001",10);
        GumballMonitor gumballMonitor=new GumballMonitor(machine);
        gumballMonitor.report();
    }
}
