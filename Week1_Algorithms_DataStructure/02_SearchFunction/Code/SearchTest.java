// File: SearchTest.java
public class SearchTest {
    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Shoes", "Footwear"),
            new Product(102, "Phone", "Electronics"),
            new Product(103, "Watch", "Accessories"),
            new Product(104, "Laptop", "Electronics"),
            new Product(105, "Bag", "Luggage")
        };

        // Test Linear Search
        System.out.println("🔍 Linear Search Result:");
        Product found1 = SearchFunction.linearSearch(products, "Watch");
        System.out.println(found1 != null ? found1 : "Product not found");

        // Prepare and Test Binary Search
        SearchFunction.sortProductsByName(products);
        System.out.println("\n🔍 Binary Search Result:");
        Product found2 = SearchFunction.binarySearch(products, "Watch");
        System.out.println(found2 != null ? found2 : "Product not found");
    }
}
