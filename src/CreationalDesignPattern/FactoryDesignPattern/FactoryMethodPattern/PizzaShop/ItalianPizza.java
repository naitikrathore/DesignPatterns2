package CreationalDesignPattern.FactoryDesignPattern.FactoryMethodPattern.PizzaShop;

class ItalianPizza implements Pizza {

    public void prepare() {
        System.out.println("ItalianPizza Prepared.");
    }
}