package BehavioralDesignPattern;

import BehavioralDesignPattern.TemplateMethodPattern.CSVDataProcessor;
import BehavioralDesignPattern.TemplateMethodPattern.DataProcessor;
import BehavioralDesignPattern.TemplateMethodPattern.JSONDataProcessor;

public class TemplateMain {
    public static void main(String[] args) {
        System.out.println("=== CSV Processing ===");
        DataProcessor csvProcessor = new CSVDataProcessor();
        csvProcessor.processData();


        System.out.println("\n=== JSON Processing ===");
        DataProcessor jsonProcessor = new JSONDataProcessor();
        jsonProcessor.processData();
    }
}
