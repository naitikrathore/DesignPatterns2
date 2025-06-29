package CreationalDesignPattern.FactoryDesignPattern.FactoryMethodPattern.DialogApp;

//Concrete Product 2
class StopTimeShiftDialog implements Dialog {
    public void createDialog() {
        System.out.println("StopTimeShiftDialog created");
    }
}
