package CreationalDesignPattern.BuilderDesignPattern.WithDirector;

public class Director {
    private HouseBuilder houseBuilder;

    public Director(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public void constructLuxuryHouse() {
        this.houseBuilder.buildWalls();
        this.houseBuilder.buildRoof();
        this.houseBuilder.buildGarage();
        this.houseBuilder.buildSwimmingPool();
    }

    public void constructBasicHouse() {
        this.houseBuilder.buildWalls();
        this.houseBuilder.buildRoof();
    }
}
