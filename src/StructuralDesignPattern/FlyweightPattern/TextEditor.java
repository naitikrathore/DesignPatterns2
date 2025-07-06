package StructuralDesignPattern.FlyweightPattern;

import java.util.ArrayList;
import java.util.List;

// Client class: holds document as list of character contexts
public class TextEditor {
    private final List<CharacterContext> characters = new ArrayList<>();

    public void addCharacter(char character, String fontFamily, int fontSize, String color, int x, int y) {
        CharacterFlyweight flyweight = CharacterFlyweightFactory.getFlyweight(character, fontFamily, fontSize, color);
        CharacterContext context = new CharacterContext(x, y, flyweight);
        characters.add(context);
    }

    public void displayDocument() {
        System.out.println("\n--- Displaying Document ---");
        for (CharacterContext context : characters) {
            context.display();
        }
    }

    public void printStatistics() {
        System.out.println("\n--- Document Statistics ---");
        System.out.println("Total characters rendered: " + characters.size());
        System.out.println("Unique flyweights used: " + CharacterFlyweightFactory.getFlyweightCount());
        System.out.println("Memory saved: " + (characters.size() - CharacterFlyweightFactory.getFlyweightCount()) + " objects");
    }
}

