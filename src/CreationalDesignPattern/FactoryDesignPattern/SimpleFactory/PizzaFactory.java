package CreationalDesignPattern.FactoryDesignPattern.SimpleFactory;

//Creater or Factory
class PizzaFactory {

static Pizza createPizza(PizzaType type) {
    if (type == PizzaType.CHICKEN) {
        System.out.println("Creating object of ChickenPizza()");
        return new ChickenPizza();
    } else if (type == PizzaType.PANNER) {
        System.out.println("Creating object of PannerPizza()");
        return new PannerPizza();
    } else if (type == PizzaType.CHEESE) {
        System.out.println("Creating object of CheesePizza()");
        return new CheesePizza();
    } else {
        throw new IllegalArgumentException("Unknown Type: " + String.valueOf(type));
    }
}
}