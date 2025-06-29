package CreationalDesignPattern.FactoryDesignPattern.AbstractFactoryPattern.Product;

public class WindowsCheckbox implements Checkbox {

    public void toggle() {
        System.out.println("Rendering Windows Checkbox");
    }
}