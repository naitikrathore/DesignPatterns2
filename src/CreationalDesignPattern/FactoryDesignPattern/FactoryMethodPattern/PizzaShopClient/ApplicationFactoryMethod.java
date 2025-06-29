package CreationalDesignPattern.FactoryDesignPattern.FactoryMethodPattern.PizzaShopClient;

import CreationalDesignPattern.FactoryDesignPattern.FactoryMethodPattern.PizzaShop.Dominos;
import CreationalDesignPattern.FactoryDesignPattern.FactoryMethodPattern.PizzaShop.PizzaFactory;
import CreationalDesignPattern.FactoryDesignPattern.FactoryMethodPattern.PizzaShop.PizzaHut;

public class ApplicationFactoryMethod {
    public static void main(String[] args) {
        PizzaFactory dominosFactory = new Dominos();
        dominosFactory.orderIndianPizza();
        dominosFactory.orderItalianPizza();
        dominosFactory.orderSpanishPizza();


        System.out.println("----------");
        System.out.println("----------");
        System.out.println("----------");


        PizzaFactory pizzaHutFactory = new PizzaHut();
        pizzaHutFactory.orderIndianPizza();
        pizzaHutFactory.orderItalianPizza();
        pizzaHutFactory.orderSpanishPizza();
    }
}
