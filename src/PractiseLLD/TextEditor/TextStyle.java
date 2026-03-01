package PractiseLLD.TextEditor;

public class TextStyle {
    private final String font;
    private final int size;
    private final boolean bold;
    private final boolean italic;
    private final String color;

    public TextStyle(String font, int size, boolean bold, boolean italic, String color) {
        this.font = font;
        this.size = size;
        this.bold = bold;
        this.italic = italic;
        this.color = color;
    }

    public void applyStyle() {
        System.out.print("[Font=" + font +
                ", Size=" + size +
                ", Bold=" + bold +
                ", Italic=" + italic +
                ", Color=" + color + "] ");
    }
}
