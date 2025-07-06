package StructuralDesignPattern.FlyweightPattern;

// This class holds both intrinsic and extrinsic state for every character
public class CharacterWithoutFlyweight {
    private final char character;
    private final String fontFamily;
    private final int fontSize;
    private final String color;
    private final int x, y;  // position (extrinsic)

    public CharacterWithoutFlyweight(char character, String fontFamily, int fontSize, String color, int x, int y) {
        this.character = character;
        this.fontFamily = fontFamily;
        this.fontSize = fontSize;
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public void display() {
        System.out.println("Character: " + character + " at (" + x + "," + y +
                ") Font: " + fontFamily + " Size: " + fontSize + " Color: " + color);
    }
}

