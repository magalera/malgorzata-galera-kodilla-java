package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String SHOPPING_TASK = "SHOPPING TASK";
    public static final String PAINTING_TASK = "PAINTING_TASK";
    public static final String DRIVING_TASK = "DRIVING_TASK";

    public Task doTheTask(final String taskClass) {
        switch (taskClass) {
            case SHOPPING_TASK:
                return new ShoppingTask("Shopping", "Paint", 5.0);
            case PAINTING_TASK:
                return new PaintingTask("Painting", "Green", "Living room");
            case DRIVING_TASK:
                return new DrivingTask("Driving", "To store", "car");
            default:
                return null;
        }
    }
}
