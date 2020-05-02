package com.kodilla.kodillapatterns2.adapter.bookclassifier;

import com.kodilla.kodillapatterns2.adapter.bookclasifier.MedianAdapter;
import com.kodilla.kodillapatterns2.adapter.bookclasifier.librarya.Book;
import com.kodilla.kodillapatterns2.adapter.bookclasifier.libraryb.Statistic;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class MedianAdapterTestSuite {

    @Test
    public void testPublicationYearMedianTest() {
        //Given
        Book book1 = new Book("John Joey", "Your brother", 2020, "2423424");
        Book book2 = new Book("Lenny Witz", "Milky Way", 2006, "2424645");
        Book book3 = new Book("Lara Stay", "Nothing else worry", 2010, "3543568");

        Statistic statistic = new Statistic();
        MedianAdapter medianAdapter = new MedianAdapter(statistic);
        Set<Book> books = new HashSet<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);

        //When
        int publicationYearMedian = medianAdapter.publicationYearMedian(books);

        //Then
        assertEquals(2010, publicationYearMedian);

    }
}
