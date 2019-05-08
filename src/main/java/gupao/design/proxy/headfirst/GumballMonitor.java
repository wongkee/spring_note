package gupao.design.proxy.headfirst;

import java.net.ServerSocket;

public class GumballMonitor {
    GumballMachine machine;
    public GumballMonitor(GumballMachine machine){
        this.machine=machine;
    }
    public void report(){
        System.out.println("Gumball Machine: "+machine.getLocation());
        System.out.println("Current inventory: "+machine.getCount()+" gumballs");
    }
}
