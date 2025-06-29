package CreationalDesignPattern.BuilderDesignPattern.PizzaShop;

public class TastyPizzaBuilder {
    private Pizza pizza;

    public TastyPizzaBuilder(){
        this.pizza = new Pizza();
    }

    public void buildSize(String size) {
        pizza.setSize(size);
    }

    public void buildCrust(String crust){
        pizza.setCrust(crust);
    }

    public void buildPanner(){
        pizza.setAddPaneer(true);
    }

    public void buildCheese(){
        pizza.setAddCheese(true);
    }

    public void buildOnion(){
        pizza.setAddOnion(true);
    }

    public Pizza getPizza(){
        return pizza;
    }
}
