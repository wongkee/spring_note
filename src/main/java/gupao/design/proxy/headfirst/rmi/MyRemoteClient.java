package gupao.design.proxy.headfirst.rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MyRemoteClient {
    public static void main(String args[]){
        new MyRemoteClient().go();
    }
    public void go(){

        try {
            String name="gupao.design.proxy.headfirst.rmi";
            Registry registry= LocateRegistry.getRegistry("localhost",1089);
            MyRemote service=(MyRemote)registry.lookup(name);
            String s=service.sayHello();
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
