package CreationalDesignPattern.FactoryDesignPattern.FactoryMethodPattern.DialogApp;

//Creator
abstract class DialogFactory {

    abstract Dialog createDialogInstance();

    void createDialog() {
        System.out.println("DialogCreation");

        Dialog dialogInstance = this.createDialogInstance();
        dialogInstance.createDialog();
    }
}
