package PractiseLLD.TextEditor;

import java.util.ArrayList;
import java.util.List;

public class Document implements DocumentComponent{
    private final List<Paragraph> paragraphs = new ArrayList<>();
    private final List<DocumentObserver> renderers = new ArrayList<>();

    public void addParagraph(Paragraph paragraph){
        paragraphs.add(paragraph);
        notifyObservers();
    }

    public void removeParagraph(Paragraph paragraph){
        paragraphs.remove(paragraph);
        notifyObservers();
    }

    public List<Paragraph> getParagraphs() {
        return paragraphs;
    }

    @Override
    public void render() {
        System.out.println("Rendering Document");
        for (Paragraph paragraph : paragraphs) {
            paragraph.render();
        }
    }

    public void notifyObservers() {
        for (DocumentObserver observer : renderers) {
            observer.update();
        }
    }

    public void addObserver(DocumentObserver observer) {
        renderers.add(observer);
    }

    public void removeObserver(DocumentObserver observer) {
        renderers.remove(observer);
    }
}
