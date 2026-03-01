package PractiseLLD.TextEditor;

public class Editor {
    private static Editor instance;
    private Document document;
    private UndoManager undoManager;

    private Editor(){
        createNewDocument();
    }

    public void createNewDocument(){
        document = new Document();
        undoManager = new UndoManager();
        System.out.println("\n--- New Document Created ---");
    }

    public Document getDocument(){
        return document;
    }

    public synchronized static Editor getInstance() {
        if (instance == null) {
            instance = new Editor();
        }
        return instance;
    }

    public void insertText(Paragraph paragraph, String text){
        TextStyle style =  TextStyleFactory.getTextStyle("Arial", 12, false, false, "Black");
        ParagraphCommand command = new InsertTextCommand(paragraph, text, style);
        command.execute();
        undoManager.execute(command);
        document.notifyObservers();
    }

    public void undo(){
        undoManager.undo();
        document.notifyObservers();
    }

    public void redo(){
        undoManager.redo();
        document.notifyObservers();
    }

    public void export(ExportStrategy strategy){
        System.out.println("Editor is exporting");
        strategy.export(document);
    }
}
