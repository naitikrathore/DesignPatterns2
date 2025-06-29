package CreationalDesignPattern.BuilderDesignPattern.WithDirector;

public class LuxuryHouseBuilder implements HouseBuilder {
    private House house = new House();

    public void buildWalls() {
        this.house.setWalls("Brick Walls");
    }

    public void buildRoof() {
        this.house.setRoof("Concrete Roof");
    }

    public void buildGarage() {
        this.house.setHasGarage(true);
    }

    public void buildSwimmingPool() {
        this.house.setHasSwimmingPool(true);
    }

    public House getHouse() {
        return this.house;
    }
}
