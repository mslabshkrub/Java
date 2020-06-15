import by.gsu.pms.OperationContainer;
import by.gsu.pms.ThreadGenerator;
import by.gsu.pms.operation.Operation;
import by.gsu.pms.task.MultiplyOfOddNum;
import by.gsu.pms.task.Task;

import java.util.Scanner;

public class CalculatorThread {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a (from 2) ");
        int max = Integer.parseInt(scanner.next());

        System.out.println("Enter operation (+, -, *) ");
        Operation operation = OperationContainer.getOperation(scanner.next());

        System.out.println("Enter thread count ");
        int threadCount = Integer.parseInt(scanner.next());

        Task task = new MultiplyOfOddNum(max);
        ThreadGenerator threadGenerator = new ThreadGenerator(threadCount, task, operation);
        System.out.println("Your result " + threadGenerator.getResult());
    }
}
