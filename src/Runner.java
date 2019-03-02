import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Runner {
    private static void print(String seq, int a, int b, double meanVal) {
        System.out.println(seq);
        System.out.printf("mean from [%d, %d] = %f", a, b, meanVal);
    }

    private static double calcMeanVal(String seq, int a, int b) {
        final String SEMICOLON = ";";

        String[] vals = seq.split(SEMICOLON);
        int n = 0;
        double sum = 0;

        for (String val : vals) {
            double dVal = Double.parseDouble(val);
            if (dVal >= a && dVal <= b) {
                n++;
                sum += dVal;
            }
        }
        return sum / n;
    }

    public static void main(String[] args) {
        final String PATH = "src/";
        final String FILE_NAME = "in";
        final String EXTENSION = ".txt";
        final int A = -3, B = 8;
        final String SEMICOLON = ";";

        StringBuilder finalSeq = new StringBuilder();
        Scanner scanner = null;
        try {
            FileReader fileReader = new FileReader(PATH + FILE_NAME + EXTENSION);
            scanner = new Scanner(fileReader);
            while (scanner.hasNext()) {
                String seq = scanner.nextLine();
                finalSeq.append(seq).append(SEMICOLON);
            }
            double meanVal = calcMeanVal(finalSeq.toString(), A, B);
            print(finalSeq.toString(), A, B, meanVal);
        } catch (FileNotFoundException e) {
            System.err.println("File " + FILE_NAME + " with " + EXTENSION + " extension in" +
                    PATH + " not found");
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
