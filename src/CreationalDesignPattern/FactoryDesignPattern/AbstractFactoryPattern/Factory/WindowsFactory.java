package CreationalDesignPattern.FactoryDesignPattern.AbstractFactoryPattern.Factory;

import CreationalDesignPattern.FactoryDesignPattern.AbstractFactoryPattern.Product.Button;
import CreationalDesignPattern.FactoryDesignPattern.AbstractFactoryPattern.Product.Checkbox;
import CreationalDesignPattern.FactoryDesignPattern.AbstractFactoryPattern.Product.WindowsButton;
import CreationalDesignPattern.FactoryDesignPattern.AbstractFactoryPattern.Product.WindowsCheckbox;

public class WindowsFactory implements GUIFactory {

    public Button createButton() {
        return new WindowsButton();
    }

    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}