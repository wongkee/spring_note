package gupao.design.singleton;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class SpringSingleton implements Serializable {
    private static Map<String,SpringSingleton> map = new HashMap<String,SpringSingleton>();
    static {
        SpringSingleton single = new SpringSingleton();
        map.put(single.getClass().getName(), single); //将类名称和类的实例存储到map中
    }
    //保护的默认构造子
    protected SpringSingleton(){}
    //静态工厂方法,返还此类惟一的实例
    public static SpringSingleton getInstance(String name) {
        if(name == null) {
            name = SpringSingleton.class.getName();
        }
        if(map.get(name) == null) {
            try {
                //如果不存在该名称所对应的类的实例，则创建一个
                map.put(name, (SpringSingleton) Class.forName(name).newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return map.get(name);
    }
}
