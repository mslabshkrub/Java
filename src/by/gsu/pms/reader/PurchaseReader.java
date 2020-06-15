package by.gsu.pms.reader;

import by.gsu.pms.entity.Purchase;
import by.gsu.pms.factory.PurchaseFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PurchaseReader {
    private final String PATH;
    private final String FILE_NAME;
    private final String EXTENSION;

    public PurchaseReader(String path, String fileName, String extension) {
        PATH = path;
        FILE_NAME = fileName;
        EXTENSION = extension;
    }

    public List<Purchase> read() {
        Scanner scanner = null;
        List<Purchase> purchases = new ArrayList<>();
        try{
            FileReader fileReader = new FileReader(PATH + FILE_NAME + EXTENSION);
            scanner = new Scanner(fileReader);

            while(scanner.hasNextLine()) {
                purchases.add(PurchaseFactory.getClassFromFactory(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        return purchases;
    }
}
