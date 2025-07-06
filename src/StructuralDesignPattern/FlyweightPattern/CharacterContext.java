package StructuralDesignPattern.FlyweightPattern;

//  Stores unique position (extrinsic state) and references shared flyweight
public class CharacterContext {
    private final int x,y;
    private final CharacterFlyweight flyweight;

    public CharacterContext(int x, int y, CharacterFlyweight flyweight){
        this.x = x;
        this.y = y;
        this.flyweight = flyweight;
    }

    public void display() {
        flyweight.display(x, y);  // pass extrinsic state to shared flyweight
    }
}
