package PractiseLLD.inventoryManagementSystem.client;

import PractiseLLD.inventoryManagementSystem.factory.ProductFactory;
import PractiseLLD.inventoryManagementSystem.model.Product;
import PractiseLLD.inventoryManagementSystem.model.Warehouse;
import PractiseLLD.inventoryManagementSystem.observer.AdminPanelObserver;
import PractiseLLD.inventoryManagementSystem.observer.LowStockObserver;
import PractiseLLD.inventoryManagementSystem.service.InventoryManagementService;

public class InventoryClient {
    public static void main(String[] args) {
        InventoryManagementService inventoryManagementService = new InventoryManagementService();

        Warehouse w1 = new Warehouse(1);
        Warehouse w2 = new Warehouse(2);
        Warehouse w3 = new Warehouse(3);

        Product iphone = ProductFactory.createElectronics("1", "Iphone", "Apple", 60000);
        Product milk = ProductFactory.createGrocery("2", "Milk", 60000, "2027");

        w1.addProduct(iphone, 2);
        w1.addProduct(milk, 2);
        w2.addProduct(iphone, 1);
        w2.addProduct(milk, 1);
        w3.addProduct(iphone, 2);
        w3.addProduct(milk, 1);

        LowStockObserver observer = new AdminPanelObserver();
        inventoryManagementService.addObserver(observer);
        inventoryManagementService.addWarehouse(w1);
        inventoryManagementService.addWarehouse(w2);
        inventoryManagementService.addWarehouse(w3);

        inventoryManagementService.getAllProducts().forEach(System.out::println);

        inventoryManagementService.placeOrder(milk, 2);
        inventoryManagementService.placeOrder(iphone, 1);
    }
}
