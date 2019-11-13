package by.gsu.pms.operation;

import java.util.List;

public class Plus implements Operation {
    @Override
    public double calculate(List<Double> numbers) {
        double result = 0;
        for (Double number : numbers) {
            result += number;
        }
        return result;
    }
}
