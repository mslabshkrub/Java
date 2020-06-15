package by.gsu.pms.operation;

import java.util.List;

public class Minus implements Operation {
    @Override
    public double calculate(List<Double> numbers) {
        double result = numbers.get(0) * 2;
        for (Double number : numbers) {
            result -= number;
        }
            return result;
    }
}
