// File: LibrarySystemTest.java
public class LibrarySystemTest {
    public static void main(String[] args) {
        Book[] books = {
            new Book(101, "The Alchemist", "Paulo Coelho"),
            new Book(102, "To Kill a Mockingbird", "Harper Lee"),
            new Book(103, "1984", "George Orwell"),
            new Book(104, "Pride and Prejudice", "Jane Austen"),
            new Book(105, "The Great Gatsby", "F. Scott Fitzgerald")
        };

        // Linear Search
        System.out.println("🔍 Linear Search:");
        Book foundLinear = BookSearch.linearSearch(books, "1984");
        System.out.println(foundLinear != null ? foundLinear : "Book not found");

        // Binary Search
        BookSearch.sortBooksByTitle(books); // Must sort before binary search
        System.out.println("\n🔍 Binary Search:");
        Book foundBinary = BookSearch.binarySearch(books, "1984");
        System.out.println(foundBinary != null ? foundBinary : "Book not found");

        // Display sorted books
        System.out.println("\n📚 Sorted Book List:");
        BookSearch.listBooks(books);
    }
}
