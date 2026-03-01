package PractiseLLD.TextEditor;

import java.util.Stack;

public class UndoManager {
    private final Stack<ParagraphCommand> undoStack = new Stack<>();
    private final Stack<ParagraphCommand> redoStack = new Stack<>();

    public void execute(ParagraphCommand currentCommand) {
        undoStack.push(currentCommand);
        redoStack.clear();
    }

    public void undo() {
        if(!undoStack.isEmpty()){
            ParagraphCommand currentCommand = undoStack.pop();
            currentCommand.undo();
            redoStack.push(currentCommand);
        }
    }

    public void redo() {
        if(!redoStack.isEmpty()){
            ParagraphCommand currentCommand = redoStack.pop();
            currentCommand.execute();
            undoStack.push(currentCommand);
        }
    }
}
