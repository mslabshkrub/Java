package by.gsu.pms;

import by.gsu.pms.operation.Operation;
import by.gsu.pms.task.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadGenerator {
    private int threadCount;
    private Task task;
    private Operation operation;
    private List<Double> threadResults = new ArrayList<>();

    public ThreadGenerator(int threadCount, Task task, Operation operation) {
        this.threadCount = threadCount;
        this.task = task;
        this.operation = operation;
    }

    private void execute() {
        Callable<Double> res = () -> task.calculate();
        ExecutorService service = Executors.newFixedThreadPool(threadCount);
        for(int i = 0; i < threadCount; i++) {
            Future<Double> submit = service.submit(res);
            try {
                threadResults.add(submit.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        service.shutdown();
    }

    public double getResult() {
        execute();
        return operation.calculate(threadResults);
    }
}
