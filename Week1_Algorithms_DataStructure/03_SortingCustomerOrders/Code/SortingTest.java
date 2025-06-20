// File: SortingTest.java
public class SortingTest {
    public static void main(String[] args) {
        Order[] orders1 = {
            new Order(201, "Alice", 4999.99),
            new Order(202, "Bob", 1999.50),
            new Order(203, "Charlie", 2999.00),
            new Order(204, "David", 999.00)
        };

        Order[] orders2 = orders1.clone(); // For Quick Sort

        System.out.println("🔁 Bubble Sort:");
        OrderSorter.bubbleSort(orders1);
        OrderSorter.printOrders(orders1);

        System.out.println("\n⚡ Quick Sort:");
        OrderSorter.quickSort(orders2, 0, orders2.length - 1);
        OrderSorter.printOrders(orders2);
    }
}
