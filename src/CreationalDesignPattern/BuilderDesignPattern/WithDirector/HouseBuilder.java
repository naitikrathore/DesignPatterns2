package CreationalDesignPattern.BuilderDesignPattern.WithDirector;

public interface HouseBuilder {
    void buildWalls();

    void buildRoof();

    void buildGarage();

    void buildSwimmingPool();
}