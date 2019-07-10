package gupao.design.proxy.headfirst.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Service {
    public  static void main(String args[]){
        try {
        //    MyRemoteImpl service=new MyRemoteImpl();
         //   UnicastRemoteObject.exportObject(service,9999); 报错java.rmi.server.ExportException: object already exported
         //这是因为MyRemoteImpl继承了 UnicastRemoteObject,所以在它的构造方法中会调用父类的构造方法，而父类的构造方法中已经调用了 exportObject()。因此报错
            //   LocateRegistry.createRegistry(7787);
          //  Naming.bind("rmi://127.0.0.1/hello",service);
            //   MyRemote stub=(MyRemote)UnicastRemoteObject.exportObject(service,8080);
            //  LocateRegistry.createRegistry(1099);
            // Registry registry=LocateRegistry.getRegistry();
            //  registry.bind("Remo",stub);
           // https://segmentfault.com/a/1190000004494341

            //获得远程对象
            MyRemote service=new MyRemoteImpl();
            String name="gupao.design.proxy.headfirst.rmi";
            Registry registry1 = LocateRegistry.createRegistry(1089);
            registry1.bind(name,service);
            System.out.println("Server Start");
            //  Naming.rebind("RemoteHello",service);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
