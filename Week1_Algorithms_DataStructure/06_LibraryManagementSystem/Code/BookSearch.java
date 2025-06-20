// File: BookSearch.java
import java.util.Arrays;
import java.util.Comparator;

public class BookSearch {

    // Linear Search
    public static Book linearSearch(Book[] books, String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                return b;
            }
        }
        return null;
    }

    // Binary Search (Requires sorted array)
    public static Book binarySearch(Book[] books, String title) {
        int left = 0;
        int right = books.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = books[mid].title.compareToIgnoreCase(title);
            if (cmp == 0) return books[mid];
            if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }

        return null;
    }

    // Sort by title (for binary search)
    public static void sortBooksByTitle(Book[] books) {
        Arrays.sort(books, Comparator.comparing(b -> b.title.toLowerCase()));
    }

    // List all books
    public static void listBooks(Book[] books) {
        for (Book b : books) {
            System.out.println(b);
        }
    }
}
