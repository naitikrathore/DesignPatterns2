package CreationalDesignPattern.FactoryDesignPattern.AbstractFactoryPattern.Product;

public class WindowsButton implements Button {

    public void paint() {
        System.out.println("Rendering a Windows Button");
    }
}

