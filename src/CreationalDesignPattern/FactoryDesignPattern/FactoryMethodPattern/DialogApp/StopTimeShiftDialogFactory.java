package CreationalDesignPattern.FactoryDesignPattern.FactoryMethodPattern.DialogApp;

public class StopTimeShiftDialogFactory extends DialogFactory {

    Dialog createDialogInstance() {
        return new StopTimeShiftDialog();
    }
}
