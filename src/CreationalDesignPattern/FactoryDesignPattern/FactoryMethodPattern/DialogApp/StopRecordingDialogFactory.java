package CreationalDesignPattern.FactoryDesignPattern.FactoryMethodPattern.DialogApp;

//Concrete Creator 1
class StopRecordingDialogFactory extends DialogFactory {
    Dialog createDialogInstance() {
        return new StopRecordingDialog();
    }
}