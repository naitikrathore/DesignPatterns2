package PractiseLLD.inventoryManagementSystem.service;

import PractiseLLD.inventoryManagementSystem.model.Product;
import PractiseLLD.inventoryManagementSystem.model.Warehouse;
import PractiseLLD.inventoryManagementSystem.observer.LowStockObserver;

import java.util.ArrayList;
import java.util.List;

public class InventoryManagementService {
    private final OrderService orderService;

    public InventoryManagementService() {
        this.orderService = new OrderService();
    }

    public List<Product> getAllProducts() {
        List<Product> allProducts = new ArrayList<>();
        for (Warehouse warehouse : getAllWarehouses()) {
            allProducts.addAll(warehouse.getProducts());
        }
        return allProducts;
    }

    public List<Warehouse> getAllWarehouses() {
        return orderService.getWarehouses();
    }

    public void addWarehouse(Warehouse warehouse) {
        System.out.println("[InventoryManagementService] Register warehouse id=" + warehouse.getId());
        orderService.addWarehouse(warehouse);
    }

    public void addObserver(LowStockObserver observer) {
        System.out.println("[InventoryManagementService] Add observer " + observer.getClass().getSimpleName());
        orderService.addLowStockObserver(observer);
    }

    public void removeWarehouse(Warehouse warehouse) {
        System.out.println("[InventoryManagementService] Remove warehouse id=" + warehouse.getId());
        orderService.removeWarehouse(warehouse);
    }

    public boolean placeOrder(Product product, int quantity) {
        System.out.println("[InventoryManagementService] Place order sku=" + product.getSku() + ", quantity=" + quantity);
        return orderService.placeOrder(product, quantity);
    }
}
