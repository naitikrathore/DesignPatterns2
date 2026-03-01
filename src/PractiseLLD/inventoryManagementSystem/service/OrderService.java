package PractiseLLD.inventoryManagementSystem.service;

import PractiseLLD.inventoryManagementSystem.model.Product;
import PractiseLLD.inventoryManagementSystem.model.Warehouse;
import PractiseLLD.inventoryManagementSystem.observer.LowStockObserver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderService {
    private final List<Warehouse> warehouses = new ArrayList<>();
    private final List<LowStockObserver> lowStockObservers = new ArrayList<>();

    public boolean placeOrder(Product product, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Order quantity must be greater than zero");
        }
        System.out.println("[OrderService] Place order request sku=" + product.getSku() + ", quantity=" + quantity);
        Warehouse warehouse = getWarehouseWhereProductIsAvailable(product,quantity);

        if(warehouse == null){
            System.out.println("[OrderService] Order failed: warehouse not found for sku=" + product.getSku() + ", quantity=" + quantity);
            throw new RuntimeException("Warehouse not found");
        }

        int currentStock = warehouse.getProductStock(product.getSku());
        warehouse.updateProductStock(product,currentStock - quantity);
        System.out.println("[OrderService] Order success warehouseId=" + warehouse.getId() + ", sku=" + product.getSku() +
                ", deducted=" + quantity + ", remaining=" + (currentStock - quantity));
        if(warehouse.getProductStock(product.getSku()) == 0){
            notifyLowStock(warehouse,product,0);
        }

        return true;
    }

    private Warehouse getWarehouseWhereProductIsAvailable(Product product, int quantity){
        for(Warehouse warehouse : warehouses){
            int stock = warehouse.getProductStock(product.getSku());
            System.out.println("[OrderService] Checking warehouseId=" + warehouse.getId() + ", sku=" + product.getSku() +
                    ", stock=" + stock + ", required=" + quantity);
            if(stock >= quantity){
                return warehouse;
            }
        }

        return null;
    }

    public void addWarehouse(Warehouse warehouse){
        warehouses.add(warehouse);
        System.out.println("[OrderService] Added warehouse id=" + warehouse.getId());
    }

    public void removeWarehouse(Warehouse warehouse){
        warehouses.remove(warehouse);
        System.out.println("[OrderService] Removed warehouse id=" + warehouse.getId());
    }

    public List<Warehouse> getWarehouses() {
        return Collections.unmodifiableList(warehouses);
    }

    public void addLowStockObserver(LowStockObserver lowStockObserver) {
        lowStockObservers.add(lowStockObserver);
        System.out.println("[OrderService] Added low stock observer " + lowStockObserver.getClass().getSimpleName());
    }

    public void removeLowStockObserver(LowStockObserver lowStockObserver) {
        lowStockObservers.remove(lowStockObserver);
        System.out.println("[OrderService] Removed low stock observer " + lowStockObserver.getClass().getSimpleName());
    }

    public void notifyLowStock(Warehouse warehouse, Product product, int quantity) {
        System.out.println("[OrderService] Low stock alert warehouseId=" + warehouse.getId() + ", sku=" + product.getSku() +
                ", quantity=" + quantity);
        for (LowStockObserver lowStockObserver : lowStockObservers) {
            lowStockObserver.notifyLowStock(warehouse, product, quantity);
        }
    }
}
