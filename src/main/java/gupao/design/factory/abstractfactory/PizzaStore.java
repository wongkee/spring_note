package gupao.design.factory.abstractfactory;

import gupao.design.factory.simplefactory.Pizza;

public abstract class PizzaStore {
    public Pizza orderPizza(String type){
        Pizza pizza;
        //只在子类中实现具体类型，并不知道哪个子类实际上制作Pizza，并不知道哪些实际的具体类参与进来了。换句话说就是解耦
        pizza=createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    //我们称之为工厂方法
    abstract Pizza createPizza(String type);
}
