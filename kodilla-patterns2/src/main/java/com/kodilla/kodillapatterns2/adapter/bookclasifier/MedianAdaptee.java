package com.kodilla.kodillapatterns2.adapter.bookclasifier;

import com.kodilla.kodillapatterns2.adapter.bookclasifier.libraryb.Book;
import com.kodilla.kodillapatterns2.adapter.bookclasifier.libraryb.BookSignature;
import com.kodilla.kodillapatterns2.adapter.bookclasifier.libraryb.BookStatistic;
import com.kodilla.kodillapatterns2.adapter.bookclasifier.libraryb.Statistic;

import java.util.Map;

public class MedianAdaptee implements BookStatistic {
    private final Statistic statistic;

    public MedianAdaptee(Statistic statistic) {
        this.statistic = statistic;
    }

    @Override
    public int averagePublicationYear(Map<BookSignature, Book> books) {
        return statistic.averagePublicationYear(books);
    }

    @Override
    public int medianPublicationYear(Map<BookSignature, Book> books) {
        return statistic.medianPublicationYear(books);
    }
}
