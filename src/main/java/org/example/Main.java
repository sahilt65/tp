package org.example;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Adding books to the library
        library.addBook(new Book("978-3-16-148410-0", "Effective Java", "Joshua Bloch", 2008));
        library.addBook(new Book("978-0-13-468599-1", "Clean Code", "Robert C. Martin", 2008));

        // View available books
        System.out.println("Initial available books:");
        library.viewAvailableBooks();

        // Borrowing a book
        System.out.println("\nBorrowing 'Effective Java'...");
        library.borrowBook("978-3-16-148410-0");

        // View available books after borrowing
        System.out.println("Available books after borrowing:");
        library.viewAvailableBooks();

        // Returning a book
        System.out.println("\nReturning 'Effective Java'...");
        library.returnBook("978-3-16-148410-0");

        // View available books after returning
        System.out.println("Available books after returning:");
        library.viewAvailableBooks();
    }
}
