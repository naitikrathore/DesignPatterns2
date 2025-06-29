package CreationalDesignPattern.FactoryDesignPattern.SimpleFactory;

//Concrete Product 3
public class CheesePizza implements Pizza {
    public void prepare() {
        System.out.println("Cheese Pizza prepared.");
    }
}