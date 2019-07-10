package gupao.design.factory.simplefactory;

public class PizzaStore {
    /*
    * 只能当前类使用，但是想要使用生产Pizza的类不止这一个，可能有很多，因此将生产Pizza的逻辑封装起来，专门负责生产Pizza
    * */

   SimpleFactory factory;
   public PizzaStore(SimpleFactory factory){
       this.factory=factory;
   }

    public static Pizza orderPizza(String type){
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
    public static void main(String[] args){
        Pizza pizza=null;
        pizza=orderPizza("pepperoni");
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        /* output
        ChinesePizzaprepare...
        ChinesePizza bake...
        ChinesePizza cut...
        ChinesePizza box...
        * */


        SimpleFactory simpleFactory=new SimpleFactory();
        PizzaStore pizzaStore=new PizzaStore(simpleFactory);
        pizza=pizzaStore.factory.createPizza("greek");
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

    }
}
