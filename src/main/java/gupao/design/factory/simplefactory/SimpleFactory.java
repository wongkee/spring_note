package gupao.design.factory.simplefactory;

import gupao.design.factory.simplefactory.ChinesePizza;
import gupao.design.factory.simplefactory.GreekPizza;
import gupao.design.factory.simplefactory.PepperoniPizza;
import gupao.design.factory.simplefactory.Pizza;

/*
* 简单工厂模式
* 准确来说，简单工厂其实不是一个设计模式，反而像是一种编程习惯。
* 即专门定义一个类来负责创建其它类的实例，即创建与使用相分离
* 将负责创建类实例的方法定义为静态方法时，有称为静态工程
* 这种情况方便了它的调用，但是也有它的缺点，不能通过继承来改变继承创建方法的行为
*
* 使用情况
* 1、只需传入参数便获取你所需要的对象，但无需关心其创建细节
* 2、产品较少时，否则工厂代码非常复杂
*
* JDK中广泛的使用到简单工厂模式
* 如：
* java.text.DateFormat
* java加密技术
*
*
* 参考链接：
* https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/simple_factory.html
* */
public class SimpleFactory {
    public Pizza createPizza(String type){
        Pizza pizza=null;
        if(type.equals("chinese")){
            pizza=new ChinesePizza();
        }else if (type.equals("greek")){
            pizza=new GreekPizza();
        }else if (type.equals("pepperoni")){
            pizza=new PepperoniPizza();
        }
        return pizza;
    }
}
