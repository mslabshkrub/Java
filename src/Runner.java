import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Runner {
    private static void print(String seq, int a, int b, double minVal) {
        System.out.println(seq);
        System.out.printf("minimum outside (%d, %d) = %f", a, b, minVal);
    }

    private static double findMinVal(String seq, int a, int b) {
        final String SEMICOLON = ";";

        double minVal = Double.MAX_VALUE;
        String[] vals = seq.split(SEMICOLON);

        for (String val : vals) {
            double dVal = Double.parseDouble(val);
            if ((dVal <= a || dVal >= b) && dVal < minVal) {
                minVal = dVal;
            }
        }
        return minVal;
    }

    public static void main(String[] args) {
        final String PATH = "src/";
        final String FILE_NAME = "in";
        final String EXTENSION = ".txt";
        final String SEMICOLON = ";";
        final int A = -10, B = 5;

        StringBuilder finalSeq = new StringBuilder();

        Scanner scanner = null;
        try {
            FileReader fileReader = new FileReader(PATH + FILE_NAME + EXTENSION);
            scanner = new Scanner(fileReader);
            while (scanner.hasNext()) {
                finalSeq.append(scanner.nextLine()).append(SEMICOLON);
            }
            double minVal = findMinVal(finalSeq.toString(), A, B);
            print(finalSeq.toString(), A, B, minVal);
        } catch (FileNotFoundException e) {
            System.err.println("File " + FILE_NAME + " with extension " +
                    EXTENSION + " in " + PATH + " not found");
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
