package gupao.design.factory.abstractfactory;


import gupao.design.factory.factorymethod.Car;

/*
* 抽象工厂模式
* */
public abstract class AbstractFactory {
    protected  abstract Car getCar();
}
