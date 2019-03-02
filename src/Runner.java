import static java.lang.Math.cos;

public class Runner {
    private static double f(double x){
        return x + cos(x*x);
    }

    public static void main(String[] args) {
        double a = Double.parseDouble(args[0]), h = Double.parseDouble(args[1]);
        int n = Integer.parseInt(args[2]);

        System.out.println("a = " + a);
        System.out.println("h = " + h);
        System.out.println("a = " + n);

        while(n != 0){
            System.out.println(a + "\t" + f(a));
            a += h;
            n--;
        }
    }
}
