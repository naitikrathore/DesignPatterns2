package PractiseLLD.inventoryManagementSystem.model;

import PractiseLLD.inventoryManagementSystem.repository.ProductRepository;

import java.util.List;

public class Warehouse {
    private final long id;
    private final ProductRepository productRepository;

    public Warehouse(long id) {
        this.id = id;
        productRepository = new ProductRepository();
        System.out.println("[Warehouse] Created warehouse id=" + id);
    }

    public List<Product> getProducts() {
        return productRepository.getProducts();
    }

    public void addProduct(Product newProduct,int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        productRepository.addProduct(newProduct,quantity);
        System.out.println("[Warehouse] id=" + id + " added sku=" + newProduct.getSku() + ", quantity=" + quantity);
    }

    public void removeProduct(Product product) {
        productRepository.removeProduct(product);
        System.out.println("[Warehouse] id=" + id + " removed sku=" + product.getSku());
    }

    public void updateProductStock(Product product,int newStock){
        productRepository.updateProductQuantity(product.getSku(),newStock);
        System.out.println("[Warehouse] id=" + id + " updated stock sku=" + product.getSku() + ", newStock=" + newStock);
    }

    public int getProductStock(String sku){
        return productRepository.getProductsQuantity(sku);
    }

    public long getId() {
        return id;
    }
}
