import java.util.HashMap;
import java.util.Scanner;

// Product class
class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return "[" + productId + "] " + productName + " - Qty: " + quantity + ", Price: ₹" + price;
    }
}

// Inventory Management class
public class InventoryManager {
    HashMap<Integer, Product> inventory = new HashMap<>();

    // Add product
    public void addProduct(Product product) {
        inventory.put(product.productId, product);
        System.out.println("Product added successfully.");
    }

    // Update product
    public void updateProduct(int productId, int quantity, double price) {
        if (inventory.containsKey(productId)) {
            Product p = inventory.get(productId);
            p.quantity = quantity;
            p.price = price;
            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    // Delete product
    public void deleteProduct(int productId) {
        if (inventory.remove(productId) != null) {
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    // Display all products
    public void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("Current Inventory:");
            for (Product p : inventory.values()) {
                System.out.println(p);
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add Product\n2. Update Product\n3. Delete Product\n4. Display Inventory\n5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter Product Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int qty = scanner.nextInt();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    manager.addProduct(new Product(id, name, qty, price));
                    break;
                case 2:
                    System.out.print("Enter Product ID to update: ");
                    int uid = scanner.nextInt();
                    System.out.print("Enter new Quantity: ");
                    int newQty = scanner.nextInt();
                    System.out.print("Enter new Price: ");
                    double newPrice = scanner.nextDouble();
                    manager.updateProduct(uid, newQty, newPrice);
                    break;
                case 3:
                    System.out.print("Enter Product ID to delete: ");
                    int did = scanner.nextInt();
                    manager.deleteProduct(did);
                    break;
                case 4:
                    manager.displayInventory();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
