package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BoardTestSuite {

    @Test
    public void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.portfolio");
        TaskList toDo = context.getBean("toDo", TaskList.class);
        TaskList inProgress = context.getBean("inProgress", TaskList.class);
        TaskList done = context.getBean("done", TaskList.class);
        Board board = context.getBean(Board.class);

        String task1 = "Task to do.";
        String task2 = "Task in Progress";
        String task3 = "Task done.";

        //When
        toDo.tasks.add(task1);
        inProgress.tasks.add(task2);
        done.tasks.add(task3);

        //Then
        Assert.assertTrue(board.getToDoList().getTasks().contains(task1));
        Assert.assertTrue(board.getInProgressList().getTasks().contains(task2));
        Assert.assertTrue(board.getDoneList().getTasks().contains(task3));
    }

}