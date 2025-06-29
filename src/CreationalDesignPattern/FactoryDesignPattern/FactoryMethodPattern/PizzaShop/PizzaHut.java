package CreationalDesignPattern.FactoryDesignPattern.FactoryMethodPattern.PizzaShop;

public class PizzaHut extends PizzaFactory {

    protected Pizza createItalianPizza() {
        System.out.println("PizzaHut preparing Italian Pizza.");
        return new ItalianPizza();
    }

    protected Pizza createIndianPizza() {
        System.out.println("PizzaHut preparing Indian Pizza.");
        return new IndianPizza();
    }

    protected Pizza createSpanishPizza() {
        System.out.println("PizzaHut preparing Spanish Pizza.");
        return new SpanishPizza();
    }
}