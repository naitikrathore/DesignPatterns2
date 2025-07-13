package BehavioralDesignPattern.TemplateMethodPattern;

public class CSVDataProcessor extends DataProcessor{
    @Override
    protected void readData() {
        System.out.println("Reading data from CSV file...");
    }

    @Override
    protected void processBusinessLogic() {
        System.out.println("Applying business rules to CSV rows...");
    }

    @Override
    protected void writeResults() {
        System.out.println("Exporting processed data to CSV...");
    }

    public void CSVTestMethod(){
        System.out.println("CSVTestMethod...");
    }
}
