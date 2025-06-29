package CreationalDesignPattern.FactoryDesignPattern.FactoryMethodPattern.DialogApp;

public class ClientApp {
    public static void main(String[] args) {
        DialogFactory stopRecordingFactory = new StopRecordingDialogFactory();
        stopRecordingFactory.createDialog();

        DialogFactory stopTimeshiftDialogFacory = new StopTimeShiftDialogFactory();
        stopTimeshiftDialogFacory.createDialog();
    }
}
