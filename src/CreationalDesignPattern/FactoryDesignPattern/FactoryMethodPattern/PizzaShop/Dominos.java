package CreationalDesignPattern.FactoryDesignPattern.FactoryMethodPattern.PizzaShop;

public class Dominos extends PizzaFactory {

    protected Pizza createItalianPizza() {
        System.out.println("Dominos preparing Italian Pizza");
        return new ItalianPizza();
    }

    protected Pizza createIndianPizza() {
        System.out.println("Dominos preparing Indian Pizza");
        return new IndianPizza();
    }

    protected Pizza createSpanishPizza() {
        System.out.println("Dominos preparing Spanish Pizza");
        return new SpanishPizza();
    }
}