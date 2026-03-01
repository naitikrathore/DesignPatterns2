package PractiseLLD.TextEditor;

import java.util.HashMap;
import java.util.Map;

public class TextStyleFactory {
    private static final Map<String,TextStyle> textStylesMap = new HashMap<>();

    public static TextStyle getTextStyle(String font, int size, boolean bold,boolean italic,String color){
        String key = font + size + bold + italic + color;

        if(!textStylesMap.containsKey(key)){
            TextStyle newStyle = new TextStyle(font,size,bold,italic,color);
            textStylesMap.put(key,newStyle);
        }

        return textStylesMap.get(key);
    }

    public static int totalStyles() {
        return textStylesMap.size();
    }
}
