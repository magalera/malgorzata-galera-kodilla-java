package com.kodilla.testing.forum.statistic;

//Utwórz klasę obliczającą następujące statystyki:
//
//- liczbę użytkowników,
//- liczbę postów,
//- liczbę komentarzy,
//- średnią liczbę postów na użytkownika,
//- średnią liczbę komentarzy na użytkownika,
//- średnią liczbę komentarzy na post.

//Stworzona klasa powinna posiadać metodę calculateAdvStatistics(Statistics statistics),
// która obliczy podane powyżej wartości i zapamięta je we właściwościach (polach) klasy.

public class ForumStatistic {
    private double usersAmount;
    private double postsAmount;
    private double commentsAmount;
    private double userPostsAverage;
    private double userCommentsAverage;
    private double postCommentsAverage;

    public double getUsersAmount() {
        return usersAmount;
    }

    public double getPostsAmount() {
        return postsAmount;
    }

    public double getCommentsAmount() {
        return commentsAmount;
    }

    public double getUserPostsAverage() {
        return userPostsAverage;
    }

    public double getUserCommentsAverage() {
        return userCommentsAverage;
    }

    public double getPostCommentsAverage() {
        return postCommentsAverage;
    }

    public void calculateAdvStatistics(Statistics statistics) {
        usersAmount = statistics.usersNames().size();
        postsAmount = statistics.postsCount();
        commentsAmount = statistics.commentsCount();

        if (postsAmount == 0.0 && usersAmount == 0.0) {
            userPostsAverage = 0.0;
        } else {
            userPostsAverage = postsAmount / usersAmount;
        }

        if (commentsAmount == 0.0 && usersAmount == 0.0) {
            userCommentsAverage = 0.0;
        } else {
            userCommentsAverage = commentsAmount / usersAmount;
        }

        if (commentsAmount == 0.0 && postsAmount == 0.0) {
            postCommentsAverage = 0.0;
        } else {
            postCommentsAverage = commentsAmount / postsAmount;
        }
    }

    public void showStatistics() {
        System.out.println("UsersAmount: " + usersAmount);
        System.out.println("PostsAmount: " + postsAmount);
        System.out.println("CommentsAmount: " + commentsAmount);
        System.out.println("UserPostsAverage: " + userPostsAverage);
        System.out.println("serCommentsAverage: " + userCommentsAverage);
        System.out.println("PostCommentsAverage: " + postCommentsAverage);
    }
}
