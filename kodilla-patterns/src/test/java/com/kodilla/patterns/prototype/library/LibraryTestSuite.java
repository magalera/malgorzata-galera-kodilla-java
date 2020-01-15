package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class LibraryTestSuite {

    @Test
    public void testGetBooks() {
        //Given
        Book book1 = new Book("Book1", "Author1", LocalDate.of(2000, 2, 14));
        Book book2 = new Book("Book2", "Author2", LocalDate.of(2000, 6, 11));
        Book book3 = new Book("Book3", "Author3", LocalDate.of(2002, 12, 31));
        Book book4 = new Book("Book4", "Author4", LocalDate.of(2005, 5, 3));
        Book book5 = new Book("Book5", "Author5", LocalDate.of(2007, 10, 29));

        Library library = new Library("Books List nr 1");

        library.getBooks().add(book1);
        library.getBooks().add(book2);
        library.getBooks().add(book3);
        library.getBooks().add(book4);
        library.getBooks().add(book5);

        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
            clonedLibrary.setName("Books List nr 2");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Books List nr 3");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        library.getBooks().remove(book3);
        int actualLibrarySize = library.getBooks().size();
        int actualClonedLibrarySize = clonedLibrary.getBooks().size();
        int actualDeepClonedLibrarySize = deepClonedLibrary.getBooks().size();

        //Then
        System.out.println(library);
        System.out.println(clonedLibrary);
        System.out.println(deepClonedLibrary);
        Assert.assertEquals(4, actualLibrarySize);
        Assert.assertEquals(4, actualClonedLibrarySize);
        Assert.assertEquals(5, actualDeepClonedLibrarySize);
    }
}