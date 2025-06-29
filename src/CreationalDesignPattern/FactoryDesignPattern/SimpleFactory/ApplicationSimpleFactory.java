package CreationalDesignPattern.FactoryDesignPattern.SimpleFactory;

public class ApplicationSimpleFactory {
    public static void main(String[] args) {
        Pizza chickenPizza = PizzaFactory.createPizza(PizzaType.CHICKEN);
        chickenPizza.prepare();
        Pizza pannerPizza = PizzaFactory.createPizza(PizzaType.PANNER);
        pannerPizza.prepare();
        Pizza cheesePizza = PizzaFactory.createPizza(PizzaType.CHEESE);
        cheesePizza.prepare();
    }
}
