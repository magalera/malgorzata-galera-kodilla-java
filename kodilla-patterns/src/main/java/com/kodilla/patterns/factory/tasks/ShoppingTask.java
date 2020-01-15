package com.kodilla.patterns.factory.tasks;

import java.util.Objects;

public class ShoppingTask implements Task {

    private final String taskName;
    private final String whatToBuy;
    private final double quantity;

    public ShoppingTask(final String taskName, final String whatToBuy, final double quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
    }

    @Override
    public boolean executeTask() {
        return true;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        return !executeTask();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingTask that = (ShoppingTask) o;
        return Double.compare(that.quantity, quantity) == 0 &&
                getTaskName().equals(that.getTaskName()) &&
                whatToBuy.equals(that.whatToBuy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTaskName(), whatToBuy, quantity);
    }

    @Override
    public String toString() {
        return "ShoppingTask{" +
                "taskName='" + taskName + '\'' +
                ", whatToBuy='" + whatToBuy + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
