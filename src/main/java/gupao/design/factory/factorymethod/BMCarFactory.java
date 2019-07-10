package gupao.design.factory.factorymethod;

public class BMCarFactory implements CarFactory {
    @Override
    public Car getCar(){
        return  new BMCar();
    }
}
