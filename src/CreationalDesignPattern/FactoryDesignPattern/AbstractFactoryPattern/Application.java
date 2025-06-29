package CreationalDesignPattern.FactoryDesignPattern.AbstractFactoryPattern;

import CreationalDesignPattern.FactoryDesignPattern.AbstractFactoryPattern.Factory.GUIFactory;
import CreationalDesignPattern.FactoryDesignPattern.AbstractFactoryPattern.Product.Button;
import CreationalDesignPattern.FactoryDesignPattern.AbstractFactoryPattern.Product.Checkbox;

public class Application {
    private final Button button;
    private final Checkbox checkbox;

    public Application(GUIFactory factory) {
        this.button = factory.createButton();
        this.checkbox = factory.createCheckbox();
    }

    public void render() {
        this.button.paint();
        this.checkbox.toggle();
    }
}
