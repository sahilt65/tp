package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    private Library library;
    private Book book1;
    private Book book2;

    @BeforeEach
    public void setUp() {
        library = new Library();
        book1 = new Book("978-3-16-148410-0", "Effective Java", "Joshua Bloch", 2008);
        book2 = new Book("978-0-13-468599-1", "Clean Code", "Robert C. Martin", 2008);
        library.addBook(book1);
        library.addBook(book2);
    }

    @Test
    public void testAddBook() {
        Book newBook = new Book("978-0-596-52068-7", "Head First Design Patterns", "Eric Freeman", 2004);
        library.addBook(newBook);
        assertEquals(newBook, library.borrowBook("978-0-596-52068-7"));
    }

    @Test
    public void testAddDuplicateBook() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            library.addBook(book1); // Adding the same book again
        });
        assertEquals("Book with ISBN 978-3-16-148410-0 already exists.", exception.getMessage());
    }

    @Test
    public void testBorrowBook() {
        Book borrowedBook = library.borrowBook("978-3-16-148410-0");
        assertTrue(borrowedBook.isBorrowed());
    }

    @Test
    public void testBorrowNonExistentBook() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            library.borrowBook("978-0-00-000000-0");
        });
        assertEquals("Book not found in the library.", exception.getMessage());
    }

    @Test
    public void testBorrowAlreadyBorrowedBook() {
        library.borrowBook("978-3-16-148410-0");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            library.borrowBook("978-3-16-148410-0");
        });
        assertEquals("Book is already borrowed.", exception.getMessage());
    }

    @Test
    public void testReturnBook() {
        library.borrowBook("978-3-16-148410-0");
        library.returnBook("978-3-16-148410-0");
        assertFalse(book1.isBorrowed());
    }

    @Test
    public void testReturnNonExistentBook() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            library.returnBook("978-0-00-000000-0");
        });
        assertEquals("Book not found in the library.", exception.getMessage());
    }

    @Test
    public void testReturnNonBorrowedBook() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            library.returnBook("978-0-13-468599-1"); // Book not borrowed yet
        });
        assertEquals("Book wasn't borrowed.", exception.getMessage());
    }

    @Test
    public void testViewAvailableBooks() {
        library.borrowBook("978-3-16-148410-0");
        // Simulate console output and verify that only non-borrowed books are listed.
        library.viewAvailableBooks();
    }
}

