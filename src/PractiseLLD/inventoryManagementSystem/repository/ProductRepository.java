package PractiseLLD.inventoryManagementSystem.repository;

import PractiseLLD.inventoryManagementSystem.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository {
    private final Map<String, Product> products = new HashMap<>();
    private final Map<String, Integer> productsQuantity = new HashMap<>();

    public void addProduct(Product product, int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        products.put(product.getSku(), product);
        productsQuantity.put(product.getSku(), quantity);
        System.out.println("[ProductRepository] Upsert product sku=" + product.getSku() + ", quantity=" + quantity);
    }

    public void removeProduct(Product product){
        products.remove(product.getSku());
        productsQuantity.remove(product.getSku());
        System.out.println("[ProductRepository] Removed product sku=" + product.getSku());
    }

    public Product getProduct(String sku){
        return products.get(sku);
    }

    public List<Product> getProducts(){
        return new ArrayList<>(products.values());
    }

    public void updateProductQuantity(String sku, int quantity){
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        productsQuantity.put(sku,quantity);
        System.out.println("[ProductRepository] Updated quantity sku=" + sku + ", quantity=" + quantity);
    }

    public int getProductsQuantity(String sku) {
        return productsQuantity.getOrDefault(sku, 0);
    }
}
