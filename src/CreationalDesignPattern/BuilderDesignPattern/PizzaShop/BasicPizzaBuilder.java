package CreationalDesignPattern.BuilderDesignPattern.PizzaShop;

public class BasicPizzaBuilder{
    private Pizza pizza;

    public BasicPizzaBuilder(){
        this.pizza = new Pizza();
    }

    public void buildSize(String size) {
        pizza.setSize(size);
    }

    public void buildCrust(String crust){
        pizza.setCrust(crust);
    }

    public Pizza getPizza(){
        return pizza;
    }
}
