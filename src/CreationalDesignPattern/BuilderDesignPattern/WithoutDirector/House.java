package CreationalDesignPattern.BuilderDesignPattern.WithoutDirector;

public class House {
    private final String walls;
    private final String roof;
    private final boolean hasGarage;
    private final boolean hasSwimmingPool;

    private House(Builder builder) {
        this.walls = builder.walls;
        this.roof = builder.roof;
        this.hasGarage = builder.hasGarage;
        this.hasSwimmingPool = builder.hasSwimmingPool;
    }

    public String toString() {
        return "House [walls=" + this.walls + ", roof=" + this.roof + ", garage=" + this.hasGarage + ", pool=" + this.hasSwimmingPool + "]";
    }

    public static class Builder {
        private String walls;
        private String roof;
        private boolean hasGarage = false;
        private boolean hasSwimmingPool = false;

        public Builder setWalls(String walls) {
            this.walls = walls;
            return this;
        }

        public Builder setRoof(String roof) {
            this.roof = roof;
            return this;
        }

        public Builder setHasGarage(boolean hasGarage) {
            this.hasGarage = hasGarage;
            return this;
        }

        public Builder setHasSwimmingPool(boolean hasSwimmingPool) {
            this.hasSwimmingPool = hasSwimmingPool;
            return this;
        }

        public House build() {
            if (this.walls != null && this.roof != null) {
                return new House(this);
            } else {
                throw new IllegalStateException("Walls and roof are required!");
            }
        }
    }
}

