package StructuralDesignPattern.FlyweightPattern;

import java.util.HashMap;

//  Factory to manage and reuse flyweight objects
// Flyweight pattern almost always uses Factory pattern to manage flyweight instances:
public class CharacterFlyweightFactory {
    public static HashMap<String,CharacterFlyweight> flyweightMap = new HashMap<>();

    public static CharacterFlyweight getFlyweight(char character, String fontFamily, int fontSize, String color){
        String key = character + fontSize + fontFamily + color;

        if(!flyweightMap.containsKey(key)){
            flyweightMap.put(key, new CharacterFlyweight(character,fontFamily,fontSize,color));
            System.out.println("Created new flyweight for: " + key);
        }

        System.out.println("returning flyweight for key " + key);
        return flyweightMap.get(key);
    }

    public static int getFlyweightCount(){
        return flyweightMap.size();
    }

    public static void printFlyweights() {
        System.out.println("\n--- Flyweights Created ---");
        for (String key : flyweightMap.keySet()) {
            System.out.println("Flyweight key: " + key);
        }
    }

}
