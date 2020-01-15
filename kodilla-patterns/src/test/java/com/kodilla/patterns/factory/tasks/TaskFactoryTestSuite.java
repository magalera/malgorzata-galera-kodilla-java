package com.kodilla.patterns.factory.tasks;


import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {

    @Test
    public void testShoppingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();

        //When
        Task shopping = taskFactory.doTheTask(TaskFactory.SHOPPING_TASK);

        //Then
        Assert.assertEquals("Shopping", shopping.getTaskName());
        Assert.assertFalse(shopping.isTaskExecuted());
    }

    @Test
    public void testPaintingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();

        //When
        Task painting = taskFactory.doTheTask(TaskFactory.PAINTING_TASK);

        //Then
        Assert.assertEquals("Painting", painting.getTaskName());
        Assert.assertTrue(painting.isTaskExecuted());
    }

    @Test
    public void testDrivingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();

        //When
        Task driving = taskFactory.doTheTask(TaskFactory.DRIVING_TASK);

        //Then
        Assert.assertEquals("Driving", driving.getTaskName());
        Assert.assertFalse(driving.isTaskExecuted());
    }
}