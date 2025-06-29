package CreationalDesignPattern.FactoryDesignPattern.FactoryMethodPattern.DialogApp;

//Concrete Creator 2
public class StopTimeShiftDialogFactory extends DialogFactory {

    Dialog createDialogInstance() {
        return new StopTimeShiftDialog();
    }
}
