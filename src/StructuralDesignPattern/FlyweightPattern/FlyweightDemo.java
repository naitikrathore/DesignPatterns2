package StructuralDesignPattern.FlyweightPattern;

public class FlyweightDemo {
    // Same formatting (shared flyweights)
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        System.out.println("With FlyWeight+++++++++++");
        editor.addCharacter('A', "Arial", 12, "Black", 0, 0);
        editor.addCharacter('A', "Arial", 12, "Black", 1, 0);
        editor.addCharacter('B', "Arial", 12, "Black", 2, 0);
        editor.addCharacter('A', "Arial", 12, "Black", 3, 0);
        editor.addCharacter('C', "Arial", 12, "Black", 4, 0);

        // Different formatting (new flyweights)
        editor.addCharacter('A', "Times", 14, "Red", 0, 1);
        editor.addCharacter('B', "Times", 14, "Red", 1, 1);

        // Output
        editor.displayDocument();
        editor.printStatistics();
        CharacterFlyweightFactory.printFlyweights();



        System.out.println("Without FlyWeight-------------");
        TextEditorWithoutFlyweight editor2 = new TextEditorWithoutFlyweight();

        // Adding repeated characters with same formatting (but not shared)
        editor2.addCharacter('A', "Arial", 12, "Black", 0, 0);
        editor2.addCharacter('A', "Arial", 12, "Black", 1, 0);
        editor2.addCharacter('B', "Arial", 12, "Black", 2, 0);
        editor2.addCharacter('A', "Arial", 12, "Black", 3, 0);
        editor2.addCharacter('C', "Arial", 12, "Black", 4, 0);

        // Characters with different formatting
        editor2.addCharacter('A', "Times", 14, "Red", 0, 1);
        editor2.addCharacter('B', "Times", 14, "Red", 1, 1);

        editor2.displayDocument();
        editor2.printStatistics();
    }
}
