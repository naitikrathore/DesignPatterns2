package CreationalDesignPattern.FactoryDesignPattern.AbstractFactoryPattern;

import CreationalDesignPattern.FactoryDesignPattern.AbstractFactoryPattern.Factory.GUIFactory;
import CreationalDesignPattern.FactoryDesignPattern.AbstractFactoryPattern.Factory.MacFactory;
import CreationalDesignPattern.FactoryDesignPattern.AbstractFactoryPattern.Factory.WindowsFactory;

public class ApplicationConfigurator {

    public static void main(String[] args) {
        String os = "MAC";
        GUIFactory factory;
        if (os.equalsIgnoreCase("MAC")) {
            factory = new MacFactory();
        } else {
            factory = new WindowsFactory();
        }

        Application app = new Application(factory);
        app.render();
    }
}
