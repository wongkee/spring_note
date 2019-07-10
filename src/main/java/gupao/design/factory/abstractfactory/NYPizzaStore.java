package gupao.design.factory.abstractfactory;

import gupao.design.factory.simplefactory.Pizza;

public class NYPizzaStore extends PizzaStore {
    /*
    * 每一个PizzaStore自己决定自己如何制造Pizza
    *Pizza店决定了制作哪个口味的Pizza
    * 准确来说，是顾客决定了哪个口味，顾客去哪家购买，决定了Pizza的口味
    * orderPizza 默认继承了父类的，因此每一个加盟店对于订单的处理都是一致的
    * */
    @Override
    Pizza createPizza(String type) {
        //创建纽约风味的Pizza
        Pizza pizza=null;
        if(type.equals("chinese")){
            pizza=new NYChinesePizza();
        }else if (type.equals("greek")){
            pizza=new NYGreekPizza();
        }else if (type.equals("pepperoni")){
            pizza=new NYPepperoniPizza();
        }
        return pizza;
    }
}
