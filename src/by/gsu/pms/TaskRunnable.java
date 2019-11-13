package by.gsu.pms;

import by.gsu.pms.task.Task;

public class TaskRunnable implements Runnable {

    private Task task;
    private double result;

    public TaskRunnable(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        result = task.calculate();
    }

    public double getResult() {
        return result;
    }
}
