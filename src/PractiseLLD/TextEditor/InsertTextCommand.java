package PractiseLLD.TextEditor;

public class InsertTextCommand implements ParagraphCommand {
    private final Paragraph paragraph;
    private final String text;
    private final TextStyle textStyle;
    private TextRun currentTextRun;

    public InsertTextCommand(Paragraph paragraph,String text,TextStyle style) {
        this.paragraph = paragraph;
        this.text = text;
        this.textStyle = style;
    }

    @Override
    public void execute() {
        currentTextRun = new TextRun(text, textStyle);
        paragraph.addTextTun(currentTextRun);
    }

    @Override
    public void undo() {
        paragraph.removeTextRun(currentTextRun);
    }
}
