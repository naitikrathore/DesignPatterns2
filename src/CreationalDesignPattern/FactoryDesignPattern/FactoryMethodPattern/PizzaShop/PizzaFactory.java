package CreationalDesignPattern.FactoryDesignPattern.FactoryMethodPattern.PizzaShop;

public abstract class PizzaFactory {

    protected abstract Pizza createItalianPizza();

    protected abstract Pizza createIndianPizza();

    protected abstract Pizza createSpanishPizza();

    public void orderItalianPizza() {
        Pizza pizza = this.createItalianPizza();
        System.out.println("Italian Pizza Ordered.");
        pizza.prepare();
    }

    public void orderIndianPizza() {
        Pizza pizza = this.createIndianPizza();
        System.out.println("Indian Pizza Ordered.");
        pizza.prepare();
    }

    public void orderSpanishPizza() {
        Pizza pizza = this.createSpanishPizza();
        System.out.println("Spanish Pizza Ordered.");
        pizza.prepare();
    }
}
