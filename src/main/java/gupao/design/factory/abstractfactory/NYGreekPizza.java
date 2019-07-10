package gupao.design.factory.abstractfactory;

import gupao.design.factory.simplefactory.Pizza;

public class NYGreekPizza implements Pizza {
    @Override
    public void prepare() {
        System.out.println("NYGreekPizza prepare");
    }

    @Override
    public void bake() {
        System.out.println("NYGreekPizza bake");
    }

    @Override
    public void cut() {
        System.out.println("NYGreekPizza cut");
    }

    @Override
    public void box() {
        System.out.println("NYGreekPizza box");
    }
}
