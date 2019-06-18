package test;

import com.ibm.icu.impl.USerializedSet;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_in_action.beans.xmlconfig.User;

public class SpringConfigTest {
    public static  void main(String args[]){
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");
        //2.从IOC容器中获取bean对象
        User user=(User)context.getBean("user");
        //3、调用方法
        System.out.println(user.toString());

        //通过类获取，当配置文件中只存在一个该类的对象时
        User user1=(User)context.getBean("user1");
        System.out.println(user1.toString());

    }
}
