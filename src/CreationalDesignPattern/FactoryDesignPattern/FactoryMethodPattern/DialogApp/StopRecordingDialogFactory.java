package CreationalDesignPattern.FactoryDesignPattern.FactoryMethodPattern.DialogApp;

class StopRecordingDialogFactory extends DialogFactory {
    Dialog createDialogInstance() {
        return new StopRecordingDialog();
    }
}