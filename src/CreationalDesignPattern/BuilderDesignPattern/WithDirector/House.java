package CreationalDesignPattern.BuilderDesignPattern.WithDirector;

public class House {
    private String walls;
    private String roof;
    private boolean hasGarage;
    private boolean hasSwimmingPool;

    public void setWalls(String walls) {
        this.walls = walls;
    }

    public void setRoof(String roof) {
        this.roof = roof;
    }

    public void setHasGarage(boolean hasGarage) {
        this.hasGarage = hasGarage;
    }

    public void setHasSwimmingPool(boolean hasSwimmingPool) {
        this.hasSwimmingPool = hasSwimmingPool;
    }

    public String toString() {
        return "House [walls=" + this.walls + ", roof=" + this.roof + ", garage=" + this.hasGarage + ", pool=" + this.hasSwimmingPool + "]";
    }
}
