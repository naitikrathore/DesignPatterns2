package BehavioralDesignPattern.TemplateMethodPattern;

public class JSONDataProcessor extends DataProcessor{
    @Override
    protected void readData() {
        System.out.println("Reading JSON data from REST API...");
    }

    @Override
    protected void processBusinessLogic() {
        System.out.println("Transforming JSON into internal models...");
    }

    @Override
    protected void writeResults() {
        System.out.println("Returning processed data as JSON response...");
    }
}
