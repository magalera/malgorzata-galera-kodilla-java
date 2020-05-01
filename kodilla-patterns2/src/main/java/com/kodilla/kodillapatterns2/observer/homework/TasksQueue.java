package com.kodilla.kodillapatterns2.observer.homework;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TasksQueue implements Observable {
    private final List<Observer> observers;
    private final Deque<String> tasks;
    private final String name;

    public TasksQueue(String name) {
        this.observers = new ArrayList<>();
        this.tasks = new ArrayDeque<>();
        this.name = name;
    }

    public void addTask(String task) {
        tasks.add(task);
        notifyObserver();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public Deque<String> getTasks() {
        return tasks;
    }

    public String getName() {
        return name;
    }
}
