package gupao.design.factory.simplefactory;

public class ChinesePizza implements Pizza {
    @Override
    public void prepare() {
        System.out.println("ChinesePizzaprepare...");
    }

    @Override
    public void bake() {
        System.out.println("ChinesePizza bake...");
    }

    @Override
    public void cut() {
        System.out.println("ChinesePizza cut...");
    }

    @Override
    public void box() {
        System.out.println("ChinesePizza box...");
    }
}
