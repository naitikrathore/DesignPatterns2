package PractiseLLD.TextEditor;

import java.util.ArrayList;
import java.util.List;

public class Paragraph implements DocumentComponent{

    List<TextRun> textRuns = new ArrayList<>();

    public void addTextTun(TextRun textRun){
        textRuns.add(textRun);
    }

    public void removeTextRun(TextRun textRun){
        textRuns.remove(textRun);
    }

    @Override
    public void render() {
        System.out.println("Rendering paragraph");
        for (TextRun textRun : textRuns) {
            textRun.render();
        }
    }
}
