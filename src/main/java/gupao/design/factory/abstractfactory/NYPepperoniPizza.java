package gupao.design.factory.abstractfactory;

import gupao.design.factory.simplefactory.Pizza;

public class NYPepperoniPizza implements Pizza {
    @Override
    public void prepare() {
        System.out.println("PepperoniPizza prepare");
    }

    @Override
    public void bake() {
        System.out.println("PepperoniPizza bake");
    }

    @Override
    public void cut() {
        System.out.println("PepperoniPizza cut");
    }

    @Override
    public void box() {
        System.out.println("PepperoniPizza box");
    }
}
