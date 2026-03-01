package PractiseLLD.TextEditor;


public class TextRun implements DocumentComponent{
    String text;
    TextStyle style;

    public TextRun(String text, TextStyle style) {
        this.text = text;
        this.style = style;
    }

    @Override
    public void render() {
        System.out.println("Text: " + text);
    }
}
