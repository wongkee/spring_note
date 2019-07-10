package gupao.design.factory.factorymethod;

public class BenzCarFactory implements CarFactory {
    @Override
    public Car getCar() {
        return new BezCar();
    }
}
