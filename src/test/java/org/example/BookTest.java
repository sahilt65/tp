package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    @Test
    public void testBookCreation() {
        Book book = new Book("978-3-16-148410-0", "Effective Java", "Joshua Bloch", 2008);
        assertEquals("978-3-16-148410-0", book.getIsbn());
        assertEquals("Effective Java", book.getTitle());
        assertEquals("Joshua Bloch", book.getAuthor());
        assertEquals(2008, book.getYear());
        assertFalse(book.isBorrowed());
    }

}

