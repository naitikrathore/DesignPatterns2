package CreationalDesignPattern.FactoryDesignPattern.SimpleFactory;

//Concrete Product 2
public class ChickenPizza implements Pizza {

    public void prepare() {
        System.out.println("Chicken Pizza Prepared.");
    }
}