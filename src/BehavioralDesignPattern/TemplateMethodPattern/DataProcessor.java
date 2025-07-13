package BehavioralDesignPattern.TemplateMethodPattern;

// - Define the skeleton of an algorithm in a base class.
// - Subclasses override specific steps without changing the overall structure.
// - Ensures consistent flow across implementations while allowing flexibility.
// ============================================================================

// STEP 1: ABSTRACT CLASS defines the TEMPLATE METHODS
public abstract class DataProcessor {

    // === TEMPLATE METHOD 1 ===
    // - Defines the fixed sequence of steps to process data.
    // - Marked 'final' so subclasses can't modify the algorithm structure.

    public final void processData(){
        validateInput();
        readData();
        processBusinessLogic();
        writeResults();
        cleanup();
    }

    protected abstract void readData();
    protected abstract void processBusinessLogic();
    protected abstract void writeResults();

    // === CONCRETE METHOD ===
    // - Common implementation shared by all subclasses
    protected void validateInput() {
        System.out.println("Validating input...");
    }

    // === CONCRETE METHOD ===
    protected void cleanup() {
        System.out.println("Cleaning up temporary files and memory...");
    }
}
