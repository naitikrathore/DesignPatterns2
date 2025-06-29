package CreationalDesignPattern.FactoryDesignPattern.FactoryMethodPattern.DialogApp;

//Concrete Product 1
class StopRecordingDialog implements Dialog {
    public void createDialog() {
        System.out.println("StopRecording Dialog Created");
    }
}