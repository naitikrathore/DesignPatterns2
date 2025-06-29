package CreationalDesignPattern.BuilderDesignPattern.WithDirector;
public class MainWithDirector {
    public static void main(String[] args) {
        LuxuryHouseBuilder luxuryHouseBuilder = new LuxuryHouseBuilder();
        Director director = new Director(luxuryHouseBuilder);
        director.constructLuxuryHouse();
        House luxuryHouse = luxuryHouseBuilder.getHouse();
        System.out.println(luxuryHouse);
        BasicHouseBuilder basicHouseBuilder = new BasicHouseBuilder();
        director = new Director(basicHouseBuilder);
        director.constructBasicHouse();
        House basicHouse = basicHouseBuilder.getHouse();
        System.out.println(basicHouse);
    }
}
