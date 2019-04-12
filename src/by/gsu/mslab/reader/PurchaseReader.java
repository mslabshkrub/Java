package by.gsu.mslab.reader;

import by.gsu.mslab.entity.GeneralPurchase;
import by.gsu.mslab.factory.PurchaseFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class PurchaseReader {
    public static GeneralPurchase[] read(String filename) {
        Scanner scanner = null;
        GeneralPurchase[] tempArray = new GeneralPurchase[10];
        GeneralPurchase[] finalArray = null;
        int currentIndex = 0;
        try {
          FileReader fileReader = new FileReader(filename);
          scanner = new Scanner(fileReader);

          while (scanner.hasNextLine()) {
              if(currentIndex >= tempArray.length) {
                  GeneralPurchase[] oldArray = tempArray;
                  tempArray = new GeneralPurchase[oldArray.length * 2];
                  System.arraycopy(oldArray, 0, tempArray, 0, oldArray.length);
              }
              tempArray[currentIndex] = PurchaseFactory.getClassFromFactory(scanner);
              currentIndex++;
          }
          finalArray = new GeneralPurchase[currentIndex];
          System.arraycopy(tempArray, 0, finalArray, 0, currentIndex);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        return finalArray;
    }
}
