package PractiseLLD.inventoryManagementSystem.factory;

import PractiseLLD.inventoryManagementSystem.model.ElectronicProduct;
import PractiseLLD.inventoryManagementSystem.model.GroceryProduct;
import PractiseLLD.inventoryManagementSystem.model.Product;

public final class ProductFactory {
    private ProductFactory() {
    }

    public static Product createElectronics(String sku, String name, String brandName, double price) {
        Product product = new ElectronicProduct(sku, name, brandName, price);
        System.out.println("[ProductFactory] Created product: " + product);
        return product;
    }

    public static Product createGrocery(String sku, String name, double price, String expiryDate) {
        Product product = new GroceryProduct(sku, name, price, expiryDate);
        System.out.println("[ProductFactory] Created product: " + product);
        return product;
    }
}
