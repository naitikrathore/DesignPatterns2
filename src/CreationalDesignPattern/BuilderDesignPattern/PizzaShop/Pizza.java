package CreationalDesignPattern.BuilderDesignPattern.PizzaShop;

class Pizza {
    private String size;
    private String crust;
    private boolean addCheese;
    private boolean addPaneer;
    private boolean addOnion;

    public void setSize(String size) {
        this.size = size;
    }

    public void setCrust(String crust) {
        this.crust = crust;
    }

    public void setAddCheese(boolean addCheese) {
        this.addCheese = addCheese;
    }

    public void setAddPaneer(boolean addPaneer) {
        this.addPaneer = addPaneer;
    }

    public void setAddOnion(boolean addOnion) {
        this.addOnion = addOnion;
    }

    @Override
    public String toString() {
        return String.format("Pizza: %s %s crust with %s%s%s",
                size, crust,
                addCheese ? "cheese " : "",
                addPaneer ? "addPaneer " : "",
                addOnion ? "addOnion " : "");
    }
}
