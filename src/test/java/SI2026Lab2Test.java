import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SI2026Lab2Test {

    @Test
    public void searchBookEveryStatementTest() {

        Library library = new Library();

        library.addBook(new Book("Clean Code", "Robert Martin", "Programming"));
        library.addBook(new Book("The Hobbit", "Tolkien", "Fantasy"));

        // TEST 1:
        // title.isEmpty() == true
        // cover: throw IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            library.searchBookByTitle("");
        });

        // TEST 2:
        // valid title,book exists,not borrowed
        // cover: results.add(book)+return results
        List<Book> result = library.searchBookByTitle("Clean Code");

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Clean Code", result.get(0).getTitle());

        // TEST 3:
        // valid title, no matching book
        // cover: results.isEmpty()->return null
        List<Book> noBook = library.searchBookByTitle("Harry Potter");
        assertNull(noBook);
    }


    @Test
    public void borrowBookEveryBranchTest() {

        Library library = new Library();

        Book book = new Book("Clean Code", "Robert Martin", "Programming");

        library.addBook(book);

        // TEST 1
        // title.isEmpty() || author.isEmpty()
        assertThrows(IllegalArgumentException.class, () -> {
            library.borrowBook("", "Robert Martin");
        });

        // TEST 2
        // successful borrow
        library.borrowBook("Clean Code", "Robert Martin");
        assertTrue(book.isBorrowed());

        // TEST 3
        // already borrowed
        assertThrows(RuntimeException.class, () -> {
            library.borrowBook("Clean Code", "Robert Martin");
        });

        // TEST 4
        // book not found
        assertThrows(RuntimeException.class, () -> {
            library.borrowBook("Unknown", "Unknown");
        });
    }


    @Test
    public void searchBookMultipleConditionTest() {

        Library library = new Library();

        // TT
        Book b1 = new Book("Clean Code", "Robert", "Programming");

        // TF
        Book b2 = new Book("Java", "James", "Programming");
        b2.setBorrowed(true);

        // FT
        Book b3 = new Book("Other", "Author", "Programming");

        // FF
        Book b4 = new Book("Another", "Author", "Programming");
        b4.setBorrowed(true);

        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);
        library.addBook(b4);

        // TT
        assertNotNull(library.searchBookByTitle("Clean Code"));

        // TF
        assertNull(library.searchBookByTitle("Java"));

        // FT
        assertNull(library.searchBookByTitle("Unknown"));

        // FF
        assertNull(library.searchBookByTitle("Random"));
    }

    @Test
    public void borrowBookMultipleConditionTest() {

        Library library = new Library();

        library.addBook(new Book("Clean Code", "Robert Martin", "Programming"));

        // T F
        assertThrows(IllegalArgumentException.class, () -> {
            library.borrowBook("", "Robert Martin");
        });

        // F T
        assertThrows(IllegalArgumentException.class, () -> {
            library.borrowBook("Clean Code", "");
        });

        // F F
        assertDoesNotThrow(() -> {
            library.borrowBook("Clean Code", "Robert Martin");
        });

        // T T
        assertThrows(IllegalArgumentException.class, () -> {
            library.borrowBook("", "");
        });
    }
}