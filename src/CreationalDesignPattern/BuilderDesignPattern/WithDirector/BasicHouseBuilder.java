package CreationalDesignPattern.BuilderDesignPattern.WithDirector;

public class BasicHouseBuilder implements HouseBuilder {
    private House house = new House();

    public void buildWalls() {
        this.house.setWalls("Wooden");
    }

    public void buildRoof() {
        this.house.setRoof("Asbestos");
    }

    public void buildGarage() {
        this.house.setHasGarage(false);
    }

    public void buildSwimmingPool() {
        this.house.setHasSwimmingPool(false);
    }

    public House getHouse() {
        return this.house;
    }
}
