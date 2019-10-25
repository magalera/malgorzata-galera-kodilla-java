package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

public class Forum {
    private final List<ForumUser> theUserList = new ArrayList<>();

    public Forum() {
        theUserList.add(new ForumUser(001, "user1", 'M', 1999, 5, 12, 157));
        theUserList.add(new ForumUser(002, "user2", 'K', 1998, 12, 23, 111));
        theUserList.add(new ForumUser(003, "user3", 'M', 1997, 11, 10, 268));
        theUserList.add(new ForumUser(004, "user4", 'K', 1996, 6, 1, 1145));
        theUserList.add(new ForumUser(005, "user5", 'M', 1995, 11, 12, 16));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(theUserList);
    }
}
