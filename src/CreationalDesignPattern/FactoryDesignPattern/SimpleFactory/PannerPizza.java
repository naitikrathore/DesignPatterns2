package CreationalDesignPattern.FactoryDesignPattern.SimpleFactory;

//Concrete Product 1
public class PannerPizza implements Pizza {
    public void prepare() {
        System.out.println("Panner Pizza Prepared.");
    }
}
