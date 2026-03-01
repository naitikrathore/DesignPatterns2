package PractiseLLD.inventoryManagementSystem.model;

public class GroceryProduct extends Product{
    private final String expirationDate;

    public GroceryProduct(String sku, String name, double price, String expirationDate) {
        super(sku,name,price,ProductCategory.GROCERY);
        this.expirationDate = expirationDate;
    }

    public String getExpirationDate() {return expirationDate;}
}
