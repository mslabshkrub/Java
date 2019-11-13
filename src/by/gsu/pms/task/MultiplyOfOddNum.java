package by.gsu.pms.task;

public class MultiplyOfOddNum implements Task {

    private int max;

    public MultiplyOfOddNum(int max) {
        this.max = max;
    }

    @Override
    public double calculate() {
        double result = 1;
        for (int i = 1; i <= max; i += 2) {
            result *= i;
        }
        return result;
    }
}
