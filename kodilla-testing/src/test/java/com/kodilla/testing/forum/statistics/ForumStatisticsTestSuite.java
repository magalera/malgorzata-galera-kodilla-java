package com.kodilla.testing.forum.statistics;

import com.kodilla.testing.forum.statistic.ForumStatistic;
import com.kodilla.testing.forum.statistic.Statistics;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ForumStatisticsTestSuite {

    @Test  //#1 Test poprawności obliczeń wartości średnich dla przypadku gdy liczba postów = 0;
    public void testCalculateAdvStatisticsWhenPostIsZero() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        ArrayList<String> users = new ArrayList<>();
        users.add("Tommy");
        users.add("Maggie");

        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.commentsCount()).thenReturn(0);
        ForumStatistic forumStatistic = new ForumStatistic();

        //When
        forumStatistic.calculateAdvStatistics(statisticsMock);
        Double userPostsAverage = forumStatistic.getUserPostsAverage();
        Double userCommentsAverage = forumStatistic.getUserCommentsAverage();
        Double postCommentsAverage = forumStatistic.getPostCommentsAverage();

        //Then
        Assert.assertEquals((Double) 0.0, userPostsAverage);
        Assert.assertEquals((Double) 0.0, userCommentsAverage);
        Assert.assertEquals((Double) 0.0, postCommentsAverage);
    }

    @Test  //#2 Test poprawności obliczeń wartości średnich dla przypadku gdy liczba postów = 1000;
    public void testCalculateAdvStatisticsWhenPostIsThousand() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        ArrayList<String> users = new ArrayList<>();
        users.add("Tommy");
        users.add("Maggie");

        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.commentsCount()).thenReturn(3000);
        ForumStatistic forumStatistic = new ForumStatistic();

        //When
        forumStatistic.calculateAdvStatistics(statisticsMock);
        Double userPostsAverage = forumStatistic.getUserPostsAverage();
        Double userCommentsAverage = forumStatistic.getUserCommentsAverage();
        Double postCommentsAverage = forumStatistic.getPostCommentsAverage();

        //Then
        Assert.assertEquals((Double) 500.0, userPostsAverage);
        Assert.assertEquals((Double) 1500.0, userCommentsAverage);
        Assert.assertEquals((Double) 3.0, postCommentsAverage);
    }

    @Test  //#3 Test poprawności obliczeń wartości średnich dla przypadku gdy liczba komentarzy = 0;

    public void testCalculateAdvStatisticsWhenCommentsIsZero() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        ArrayList<String> users = new ArrayList<>();
        users.add("Tommy");
        users.add("Maggie");

        when(statisticsMock.commentsCount()).thenReturn(0);
        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(100);
        ForumStatistic forumStatistic = new ForumStatistic();

        //When
        forumStatistic.calculateAdvStatistics(statisticsMock);
        Double userPostsAverage = forumStatistic.getUserPostsAverage();
        Double userCommentsAverage = forumStatistic.getUserCommentsAverage();
        Double postCommentsAverage = forumStatistic.getPostCommentsAverage();

        //Then
        Assert.assertEquals((Double) 50.0, userPostsAverage);
        Assert.assertEquals((Double) 0.0, userCommentsAverage);
        Assert.assertEquals((Double) 0.0, postCommentsAverage);
    }

    @Test  //#4 Test poprawności obliczeń wartości średnich dla przypadku gdy liczba komentarzy < liczba postów;
    public void testCalculateAdvStatisticsWhenCommentsIsLessThanPosts() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        ArrayList<String> users = new ArrayList<>();
        users.add("Tommy");
        users.add("Maggie");

        when(statisticsMock.commentsCount()).thenReturn(87);
        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(174);
        ForumStatistic forumStatistic = new ForumStatistic();

        //When
        forumStatistic.calculateAdvStatistics(statisticsMock);
        Double userPostsAverage = forumStatistic.getUserPostsAverage();
        Double userCommentsAverage = forumStatistic.getUserCommentsAverage();
        Double postCommentsAverage = forumStatistic.getPostCommentsAverage();

        //Then
        Assert.assertEquals((Double) 87.0, userPostsAverage);
        Assert.assertEquals((Double) 43.5, userCommentsAverage);
        Assert.assertEquals((Double) 0.5, postCommentsAverage);
    }

    @Test  //#5 Test poprawności obliczeń wartości średnich dla przypadku gdy liczba komentarzy > liczba postów;
    public void testCalculateAdvStatisticsWhenCommentsIsMoreThanPosts() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        ArrayList<String> users = new ArrayList<>();
        users.add("Tommy");
        users.add("Maggie");

        when(statisticsMock.commentsCount()).thenReturn(200);
        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(100);
        ForumStatistic forumStatistic = new ForumStatistic();

        //When
        forumStatistic.calculateAdvStatistics(statisticsMock);
        Double userPostsAverage = forumStatistic.getUserPostsAverage();
        Double userCommentsAverage = forumStatistic.getUserCommentsAverage();
        Double postCommentsAverage = forumStatistic.getPostCommentsAverage();

        //Then
        Assert.assertEquals((Double) 50.0, userPostsAverage);
        Assert.assertEquals((Double) 100.0, userCommentsAverage);
        Assert.assertEquals((Double) 2.0, postCommentsAverage);
    }

    @Test  //#6 Test poprawności obliczeń wartości średnich dla przypadku gdy liczba użytkowników = 0;
    public void testCalculateAdvStatisticsWhenUsersIsZero() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        ArrayList<String> users = new ArrayList<>();

        when(statisticsMock.commentsCount()).thenReturn(0);
        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(0);
        ForumStatistic forumStatistic = new ForumStatistic();

        //When
        forumStatistic.calculateAdvStatistics(statisticsMock);
        Double userPostsAverage = forumStatistic.getUserPostsAverage();
        Double userCommentsAverage = forumStatistic.getUserCommentsAverage();
        Double postCommentsAverage = forumStatistic.getPostCommentsAverage();

        //Then
        Assert.assertEquals((Double) 0.0, userPostsAverage);
        Assert.assertEquals((Double) 0.0, userCommentsAverage);
        Assert.assertEquals((Double) 0.0, postCommentsAverage);
    }

    @Test  //#6 Test poprawności obliczeń wartości średnich dla przypadku gdy liczba użytkowników = 100;
    public void testCalculateAdvStatisticsWhenUsersIsHundred() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        ArrayList<String> users = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            users.add("User" + i);
        }

        when(statisticsMock.commentsCount()).thenReturn(200);
        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(100);
        ForumStatistic forumStatistic = new ForumStatistic();

        //When
        forumStatistic.calculateAdvStatistics(statisticsMock);
        Double userPostsAverage = forumStatistic.getUserPostsAverage();
        Double userCommentsAverage = forumStatistic.getUserCommentsAverage();
        Double postCommentsAverage = forumStatistic.getPostCommentsAverage();

        //Then
        Assert.assertEquals((Double) 1.0, userPostsAverage);
        Assert.assertEquals((Double) 2.0, userCommentsAverage);
        Assert.assertEquals((Double) 2.0, postCommentsAverage);
    }
}



