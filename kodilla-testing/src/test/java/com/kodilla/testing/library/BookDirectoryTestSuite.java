package com.kodilla.testing.library;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class BookDirectoryTestSuite {

    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<>();
        for (int n = 1; n <= booksQuantity; n++) {
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }

    @Test
    public void testListBooksWithConditionsReturnList() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks = new ArrayList<>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);
        when(libraryDatabaseMock.listBooksWithCondition("Secret"))
                .thenReturn(resultListOfBooks);

        // When
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

        // Then
        Assert.assertEquals(4, theListOfBooks.size());
    }

    @Test
    public void testListBooksWithConditionMoreThan20() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Books = new ArrayList<>();
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);
        when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                .thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks"))
                .thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FortyBooks"))
                .thenReturn(resultListOf40Books);

        // When
        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");
        // Then

        Assert.assertEquals(0, theListOfBooks0.size());
        Assert.assertEquals(15, theListOfBooks15.size());
        Assert.assertEquals(0, theListOfBooks40.size());
    }

    @Test
    public void testListBooksWithConditionFragmentShorterThan3() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf10Books = generateListOfNBooks(10);
        when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf10Books);

        // When
        List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");

        // Then
        Assert.assertEquals(0, theListOfBooks10.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
    }

    //Test przypadku, gdy użytkownik nie ma wypożyczonych żadnych książek,
    @Test
    public void testListBooksInHandsOfWhenUserDoesntHaveBooks(){
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser libraryUser = new LibraryUser("Tom", "Jones", "12345612345");
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(new ArrayList<>());

        //When
        List<Book> actualBooks = bookLibrary.listBooksInHandsOf(libraryUser);

        //Then
        Assert.assertEquals(0, actualBooks.size());
        verify(libraryDatabaseMock, times(1)).listBooksInHandsOf(libraryUser);
    }

    //Test przypadku, gdy użytkownik ma 1 wypożyczoną książkę,
    @Test
    public void testListBooksInHandsOfWhenUserHasOneBook(){
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser libraryUser = new LibraryUser("Tom", "Jones", "12345612345");
        List<Book> books = new ArrayList<>();
        books.add(new Book("Secrets of Alamo", "John Smith", 2008));
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(books);


        //When
        List<Book> actualBooks = bookLibrary.listBooksInHandsOf(libraryUser);

        //Then
        Assert.assertEquals(1, actualBooks.size());
        verify(libraryDatabaseMock, times(1)).listBooksInHandsOf(libraryUser);
    }

    //Test przypadku, gdy użytkownik ma 5 wypożyczonych książek,
    @Test
    public void testListBooksInHandsOfWhenUserHasFiveBooks(){
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser libraryUser = new LibraryUser("Tom", "Jones", "12345612345");
        List<Book> books = new ArrayList<>();
        books.add(new Book("Secrets of Alamo1", "John Smith1", 2008));
        books.add(new Book("Secrets of Alamo2", "John Smith2", 2009));
        books.add(new Book("Secrets of Alamo3", "John Smith3", 2004));
        books.add(new Book("Secrets of Alamo4", "John Smith4", 2003));
        books.add(new Book("Secrets of Alamo5", "John Smith5", 2002));
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(books);


        //When
        List<Book> actualBooks = bookLibrary.listBooksInHandsOf(libraryUser);

        //Then
        Assert.assertEquals(5, actualBooks.size());
        verify(libraryDatabaseMock, times(1)).listBooksInHandsOf(libraryUser);
    }
}


