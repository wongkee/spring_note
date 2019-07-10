package gupao.design.factory.factorymethod;

public class Test {
    /*
    * 工厂方法模式
    * 各个产品的生产商，都拥有自己的工厂
    * 需要各个用户关心产品的生产商   增加了代码使用的复杂度
    *
    * 抽象工厂来解决这个问题
    *
    * 简单工厂就是一个大杂烩，将所有的实现都放在一个简单工厂中
    *
    * 工厂方法是为每一种产品都创造一个工厂，在这个工厂中定制自己个性化的产品，只要留出统一的接口即可，比如此处的getCar()
    * */
    public static void main(String args[]){
        CarFactory carFactory=new BenzCarFactory();
        Car car=carFactory.getCar();
        car.voice();


        CarFactory carFactory1=new BMCarFactory();
        Car car1=carFactory1.getCar();
        car1.voice();
    }
}
