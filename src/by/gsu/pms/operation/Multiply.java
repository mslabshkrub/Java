package by.gsu.pms.operation;

import java.util.List;

public class Multiply implements Operation {
    @Override
    public double calculate(List<Double> numbers) {
        double result = 1;
        for (Double number : numbers) {
            result *= number;
        }
        return result;
    }
}
