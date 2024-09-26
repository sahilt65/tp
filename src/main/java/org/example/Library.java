package org.example;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<String, Book> books;

    public Library() {
        this.books = new HashMap<>();
    }

    // Add a new book to the library
    public void addBook(Book book) {
        if (books.containsKey(book.getIsbn())) {
            throw new IllegalArgumentException("Book with ISBN " + book.getIsbn() + " already exists.");
        }
        books.put(book.getIsbn(), book);
    }

    // Borrow a book from the library
    public Book borrowBook(String isbn) {
        if (!books.containsKey(isbn)) {
            throw new IllegalArgumentException("Book not found in the library.");
        }

        Book book = books.get(isbn);
        if (book.isBorrowed()) {
            throw new IllegalArgumentException("Book is already borrowed.");
        }

        book.borrowBook();
        return book;
    }

    // Return a borrowed book
    public void returnBook(String isbn) {
        if (!books.containsKey(isbn)) {
            throw new IllegalArgumentException("Book not found in the library.");
        }

        Book book = books.get(isbn);
        if (!book.isBorrowed()) {
            throw new IllegalArgumentException("Book wasn't borrowed.");
        }

        book.returnBook();
    }

    // View a list of available books
    public void viewAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : books.values()) {
            if (!book.isBorrowed()) {
                System.out.println(book);
            }
        }
    }
}

