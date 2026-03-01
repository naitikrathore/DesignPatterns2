package PractiseLLD.inventoryManagementSystem.observer;

import PractiseLLD.inventoryManagementSystem.model.Product;
import PractiseLLD.inventoryManagementSystem.model.Warehouse;

public interface LowStockObserver {
    void notifyLowStock(Warehouse warehouse, Product product, int quantity);
}
