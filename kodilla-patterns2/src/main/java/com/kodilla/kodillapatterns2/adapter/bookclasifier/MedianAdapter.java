package com.kodilla.kodillapatterns2.adapter.bookclasifier;

import com.kodilla.kodillapatterns2.adapter.bookclasifier.librarya.Book;
import com.kodilla.kodillapatterns2.adapter.bookclasifier.librarya.Classifier;
import com.kodilla.kodillapatterns2.adapter.bookclasifier.libraryb.BookSignature;
import com.kodilla.kodillapatterns2.adapter.bookclasifier.libraryb.Statistic;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MedianAdapter extends MedianAdaptee implements Classifier {

    public MedianAdapter(Statistic statistic) {
        super(statistic);
    }

    @Override
    public int publicationYearMedian(Set<Book> bookSet) {
        Map<BookSignature, com.kodilla.kodillapatterns2.adapter.bookclasifier.libraryb.Book> booksMap =
                bookSet.stream().collect(Collectors.toMap(MedianAdapter::bookSignature, MedianAdapter::convertBookAtoB));

        return super.medianPublicationYear(booksMap);
    }

    private static com.kodilla.kodillapatterns2.adapter.bookclasifier.libraryb.Book convertBookAtoB(Book book) {
        return new com.kodilla.kodillapatterns2.adapter.bookclasifier.libraryb.Book(
                book.getAuthor(), book.getTitle(), book.getPublicationYear());
    }

    private static BookSignature bookSignature(Book book) {
        return new BookSignature(book.getSignature());
    }
}
