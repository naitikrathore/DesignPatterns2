package CreationalDesignPattern.FactoryDesignPattern.AbstractFactoryPattern.Factory;

import CreationalDesignPattern.FactoryDesignPattern.AbstractFactoryPattern.Product.Button;
import CreationalDesignPattern.FactoryDesignPattern.AbstractFactoryPattern.Product.Checkbox;

public interface GUIFactory {
    Button createButton();

    Checkbox createCheckbox();
}
