package PractiseLLD.TextEditor;

public class ConsoleRendered implements DocumentObserver {
    private final Document document;

    public ConsoleRendered(Document document) {
        this.document = document;
    }

    @Override
    public void update() {
        System.out.println("ConsoleRendered received new data to render");
        document.render();
    }
}
