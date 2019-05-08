package gupao.design.proxy.headfirst.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

//定义远程对象接口
public interface MyRemote extends Remote {
    //an interface that extends <code>java.rmi.Remote</code> are available remotely.  扩展该Remote表明该接口可被远程访问
    public String sayHello() throws RemoteException;//远程调用可能会因为网络不通畅导致一些问题，因此需要抛出异常
}
