package PractiseLLD.inventoryManagementSystem.model;

public class Product {
    private final String sku;
    private final String name;
    private double price;
    private final ProductCategory category;

    protected Product(String sku, String name, double price, ProductCategory category) {
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public void updatePrice(double newPrice) {
        this.price = newPrice;
    }

    public String getSku() {return sku;}

    public String getName() {return name;}

    public double getPrice() {return price;}

    public ProductCategory getCategory() {return category;}

    @Override
    public String toString() {
        return "Product{" +
                "sku='" + sku + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category +
                '}';
    }
}
