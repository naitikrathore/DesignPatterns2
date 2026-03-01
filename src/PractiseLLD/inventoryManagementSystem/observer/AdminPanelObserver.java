package PractiseLLD.inventoryManagementSystem.observer;

import PractiseLLD.inventoryManagementSystem.model.Product;
import PractiseLLD.inventoryManagementSystem.model.Warehouse;

public class AdminPanelObserver implements LowStockObserver {

    @Override
    public void notifyLowStock(Warehouse warehouse, Product product, int quantity) {
        System.out.println("[AdminPanelObserver] Low stock warehouseId=" + warehouse.getId() +
                ", sku=" + product.getSku() + ", quantity=" + quantity);
    }
}
