package CreationalDesignPattern.BuilderDesignPattern.PizzaShop;

public class PizzaDirector {

    public Pizza makeBasicPizza(BasicPizzaBuilder builder){
        builder.buildSize("Large");
        builder.buildCrust("Thin");
        return builder.getPizza();
    }

    public Pizza makePTastyPizza(TastyPizzaBuilder builder){
        builder.buildSize("Large");
        builder.buildCrust("Thin");
        builder.buildPanner();
        builder.buildCheese();
        builder.buildOnion();
        return builder.getPizza();
    }
}
