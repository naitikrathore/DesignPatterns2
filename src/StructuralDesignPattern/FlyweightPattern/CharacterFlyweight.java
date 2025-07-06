package StructuralDesignPattern.FlyweightPattern;

// This class represents the shared intrinsic state
// Only one object per (character + font + size + color) combination
public class CharacterFlyweight {
    private final char character;
    private final String fontFamily;
    private final int fontSize;
    private  final String color;

    public CharacterFlyweight(char character, String fontFamily, int fontSize, String color){
        this.character = character;
        this.fontFamily = fontFamily;
        this.fontSize = fontSize;
        this.color = color;
    }

    // Display the character at a specific position (extrinsic state)
    public void display(int x, int y) {
        System.out.println("Character: " + character + " at (" + x + "," + y +
                ") Font: " + fontFamily + " Size: " + fontSize + " Color: " + color);
    }
}
