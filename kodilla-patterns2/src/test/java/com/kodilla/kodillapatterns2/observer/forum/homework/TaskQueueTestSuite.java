package com.kodilla.kodillapatterns2.observer.forum.homework;

import com.kodilla.kodillapatterns2.observer.homework.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TaskQueueTestSuite {

    @Test
    public void testUpdateTaskQueue() {
        //Given
        TasksQueue maggiesTaskQueue = new StudentMaggiesTasksQueue();
        TasksQueue stevensTaskQueue = new StudentStevensTaskQueue();
        TasksQueue marysTaskQueue = new StudentMarysTaskQueue();

        Mentor mentorJohn = new Mentor("John");
        Mentor mentorThomas = new Mentor("Thomas");

        maggiesTaskQueue.registerObserver(mentorThomas);
        stevensTaskQueue.registerObserver(mentorThomas);
        marysTaskQueue.registerObserver(mentorJohn);

        //When
        maggiesTaskQueue.addTask("We are building a facade for reading and writing task lists");
        maggiesTaskQueue.addTask("We decorate the pizza");
        maggiesTaskQueue.addTask("Queues with tasks to check");
        stevensTaskQueue.addTask("We create tables with tasks");
        stevensTaskQueue.addTask("We display tasks in task lists");
        marysTaskQueue.addTask("Placing the back-end application in the Heroku cloud");

        //Then
        assertEquals(5, mentorThomas.getUpdateCount());
        assertEquals(1, mentorJohn.getUpdateCount());
    }
}
