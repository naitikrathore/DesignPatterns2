package StructuralDesignPattern.FlyweightPattern;

import java.util.ArrayList;
import java.util.List;

// Each character object stores full formatting details — leads to high memory usage
public class TextEditorWithoutFlyweight {
    private final List<CharacterWithoutFlyweight> characters = new ArrayList<>();

    public void addCharacter(char character, String fontFamily, int fontSize, String color, int x, int y) {
        // Creates a full object even if style is repeated (wastes memory)
        characters.add(new CharacterWithoutFlyweight(character, fontFamily, fontSize, color, x, y));
    }

    public void displayDocument() {
        System.out.println("\n--- Displaying Document Without Flyweight ---");
        for (CharacterWithoutFlyweight character : characters) {
            character.display();
        }
    }

    public void printStatistics() {
        System.out.println("\n--- Statistics ---");
        System.out.println("Total Characters Stored: " + characters.size());
        System.out.println("Estimated memory used (no sharing): " + (characters.size() * 132) + " bytes ≈ " + (characters.size() * 132 / 1024.0) + " KB");
    }
}

