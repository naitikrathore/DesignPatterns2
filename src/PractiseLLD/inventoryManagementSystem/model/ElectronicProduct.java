package PractiseLLD.inventoryManagementSystem.model;

public class ElectronicProduct extends Product {
    private final String brandName;
    private final String warranty;

    public ElectronicProduct(String sku, String name, String brandName, double price) {
        super(sku, name, price, ProductCategory.ELECTRONICS);
        this.brandName = brandName;
        this.warranty = "12 Months";
    }

    public String getBrandName() {
        return brandName;
    }

    public String getWarranty() {
        return warranty;
    }
}
