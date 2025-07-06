package CreationalDesignPattern.BuilderDesignPattern.WithoutDirector;

public class MainForHouse {

    public static void main(String[] args) {
        House luxuryHouse = new House.Builder()
                .setWalls("Brick walls")
                .setRoof("Concrete roof")
                .setHasGarage(true)
                .setHasSwimmingPool(true)
                .build();
        System.out.println("Luxury House" + luxuryHouse.toString());

        House basicHouse = new House.Builder()
                .setWalls("Wooden walls")
                .setRoof("Asbestos roof")
                .build();

        System.out.println("Basic House" + basicHouse.toString());
    }
}
