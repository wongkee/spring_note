package gupao.design.proxy.headfirst.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


//远程对象的具体实现
public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {
    /*
    * Used for exporting a remote object with JRMP and obtaining a stub
     * that communicates to the remote object. Stubs are either generated
     * at runtime using dynamic proxy objects, or they are generated statically
     * at build time, typically using the {@code rmic} tool.
     * 译:
     * UnicastRemoteObject作用
     * 1. 导出一个使用JRMP可访问的远程对象
     * 2. 获得与远程对象交流的存根，产生存根的方法有两种
     *      （1）运行时使用动态代理对象
     *      （2）构建时静态生成（使用 rmic工具，已被抛弃，不建议使用）
     *
     * 生成远程对象的方法
     * 1、使用无参构造方法 UnicastRemoteObject()
     * 2、使用 UnicastRemoteObject(int port)
     * 3、    protected UnicastRemoteObject(int port,
                                  RMIClientSocketFactory csf,
                                  RMIServerSocketFactory ssf)
     *
     * 4、  public static RemoteStub exportObject(Remote obj)  用于静态的生成存根而且已经被弃用
     * 5、public static Remote exportObject(Remote obj, int port)
     * 6、  public static Remote exportObject(Remote obj, int port,
                                      RMIClientSocketFactory csf,
                                      RMIServerSocketFactory ssf)

                静态存根存在则使用  否则会使用java.lang.reflect.Proxy Proxy 动态生成一个
            * */
    @Override
    public String sayHello() throws RemoteException {
        return "Server says,'Hey'";
    }
    public MyRemoteImpl() throws RemoteException{
        //这里提供了一种思路 父类UnicastRemoteObject抛出的异常可以在子类的构造函数中进行处理
        /*
        *    protected UnicastRemoteObject() throws RemoteException
    {
        this(0);
    }
    子类的构造方法被调用时，父类的构造方法也会被调用，所以此处需要处理这个异常，抛出或者捕获
    UnicastRemoteObject() 被调用时变导出远程对象
        * */
        super();
    }

    /*
    *  为 JRMP 生成和使用骨架及静态存根
已过时。骨架不再必要, 而静态存根
已由动态生成的存根取代。建议用户
不再使用rmic来生成骨架和静态存根。
    * */

}

