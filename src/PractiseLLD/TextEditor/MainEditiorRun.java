package PractiseLLD.TextEditor;

public class MainEditiorRun {
    public static void main(String[] args) {

        Editor editor = Editor.getInstance();

        // First Document
        Document doc1 = editor.getDocument();
        ConsoleRendered renderer1 = new ConsoleRendered(doc1);
        doc1.addObserver(renderer1);

        Paragraph p1 = new Paragraph();
        doc1.addParagraph(p1);

        editor.insertText(p1, "First Document Text.");
        editor.insertText(p1, "Second.");

        editor.undo();
        editor.undo();

        editor.insertText(p1, "Third");


        // Create new document
        editor.createNewDocument();

        Document doc2 = editor.getDocument();
        ConsoleRendered renderer2 = new ConsoleRendered(doc2);
        doc2.addObserver(renderer2);

        Paragraph p2 = new Paragraph();
        doc2.addParagraph(p2);

        editor.insertText(p2, "Second Document Text.");
    }
}
