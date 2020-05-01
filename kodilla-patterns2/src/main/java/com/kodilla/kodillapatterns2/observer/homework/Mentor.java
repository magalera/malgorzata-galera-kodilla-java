package com.kodilla.kodillapatterns2.observer.homework;

public class Mentor implements Observer {
    private final String userName;
    private int updateCount;

    public Mentor(String userName) {
        this.userName = userName;
    }

    @Override
    public void update(TasksQueue tasksQueue) {
        System.out.println("Mentor " + userName + ": New task to check from " + tasksQueue.getName() + " - "
                + tasksQueue.getTasks().peekLast() + "\n" + "(total: " + tasksQueue.getTasks().size() + " tasks)\n");
        updateCount++;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}

