package CreationalDesignPattern.FactoryDesignPattern.AbstractFactoryPattern.Factory;

import CreationalDesignPattern.FactoryDesignPattern.AbstractFactoryPattern.Product.Button;
import CreationalDesignPattern.FactoryDesignPattern.AbstractFactoryPattern.Product.Checkbox;
import CreationalDesignPattern.FactoryDesignPattern.AbstractFactoryPattern.Product.MacButton;
import CreationalDesignPattern.FactoryDesignPattern.AbstractFactoryPattern.Product.MacCheckbox;

public class MacFactory implements GUIFactory {

    public Button createButton() {
        return new MacButton();
    }

    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}