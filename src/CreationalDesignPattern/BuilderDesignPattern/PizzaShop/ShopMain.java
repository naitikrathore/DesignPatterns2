package CreationalDesignPattern.BuilderDesignPattern.PizzaShop;

public class ShopMain {
    public static void main(String[] args) {
        PizzaDirector pizza = new PizzaDirector();
        BasicPizzaBuilder basicPizzaBuilder = new BasicPizzaBuilder();
        Pizza basicPizza = pizza.makeBasicPizza(basicPizzaBuilder);
        System.out.println("Basic Pizza: " + basicPizza.toString());


        TastyPizzaBuilder tastyPizzaBuilder = new TastyPizzaBuilder();
        Pizza tastyPizza = pizza.makePTastyPizza(tastyPizzaBuilder);
        System.out.println("Basic Pizza: " + tastyPizza.toString());
    }
}
