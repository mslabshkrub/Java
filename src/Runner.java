public class Runner {
    private static double f(double x){
        return x + Math.pow(x, 1.0/3.0);
    }

    public static void main(String[] args) {
        double a = Double.parseDouble(args[0]), b = Double.parseDouble(args[1]);
        int n = Integer.parseInt(args[2]);
        double h = (b - a) / n;

        System.out.printf("segment[%f; %f]", a, b);
        System.out.println("n = " + n);

        while (n != 0){
            System.out.println(a + "\t" + f(a));
            a += h;
            n--;
        }
    }
}
