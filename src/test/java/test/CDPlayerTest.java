package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring_in_action.beans.autowiring.*;

import static junit.framework.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)   //测试的时候自动创建Spring应用上下文
@ContextConfiguration(classes = CDPlayerConfig.class) //在CDPlayerConfig中加载配置
public class CDPlayerTest {

   // @Autowired  //将CompactDisc bean注入到测试代码之中
    //private CompactDisc cd; //此处需要注意的是  当只有一个bean满足要求的时候会自动装配，当有多个bean满足要求的时候就会报错
    /*
    *NoUniqueBeanDefinitionException: No qualifying bean of type 'spring_in_action.beans.autowiring.CompactDisc' available: expected single matching bean but found 2: harddaynight,sgtpeppers
    * 意思就是此处找到两个满足条件的bean，所以报错
    * */


    @Autowired
    private HardDayNight hardDayNight;
    @Autowired
    private SgtPeppers sgtPeppers;

    //@Autowired //此时Revolver类没用使用component进行注解，所以无法进行装配
    @Autowired(required = false)  //但是将required设置为false  就不会进行检验，但是这时候你得小心空指针异常
    private Revolver revolver;


    @Test
    public void cdShouldNotBeNull(){
        //assertNotNull(cd);
    }

    @Test
    public void playCD(){
       // cd.play();  //PlayingSgt. Pepper's Lonely Hearts Club Band by This Beatles
        hardDayNight.play();
        sgtPeppers.play();
       // revolver.play(); 报错 空指针异常
        if(revolver!=null){
            revolver.play();
        }
    }

}
