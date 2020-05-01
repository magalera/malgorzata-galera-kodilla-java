package com.kodilla.kodillapatterns2.observer.forum;

public class ForumUser implements Observer {
    private final String userName;
    private int updateCount;

    public ForumUser(String userName) {
        this.userName = userName;
    }

    @Override
    public void update(ForumTopic forumTopic) {
        System.out.println(userName + ": New posts in topic " + forumTopic.getName() + "\n" + "(total: " + forumTopic.getPosts().size() + " posts)");
        updateCount++;
    }

    public String getUserName() {
        return userName;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}
