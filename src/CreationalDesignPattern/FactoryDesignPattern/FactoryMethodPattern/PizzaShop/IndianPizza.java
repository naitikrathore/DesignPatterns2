package CreationalDesignPattern.FactoryDesignPattern.FactoryMethodPattern.PizzaShop;

class IndianPizza implements Pizza {
    public void prepare() {
        System.out.println("Indian Pizza Prepared.");
    }
}