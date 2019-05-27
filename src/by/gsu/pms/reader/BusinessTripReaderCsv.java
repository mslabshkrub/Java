package by.gsu.pms.reader;

import by.gsu.pms.model.BusinessTrip;
import by.gsu.pms.model.Byn;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class BusinessTripReaderCsv {
    private final String PATH;
    private final String FILE_NAME;
    private final String EXTENSION;

    public BusinessTripReaderCsv(String path, String fileName, String extension) {
        PATH = path;
        FILE_NAME = fileName;
        EXTENSION = extension;
    }

    public BusinessTrip[] read() {
        Scanner scanner = null;
        BusinessTrip[] businessTrips = null;
        try{
            FileReader fileReader = new FileReader(PATH + FILE_NAME + EXTENSION);
            scanner = new Scanner(fileReader);
            businessTrips = new BusinessTrip[Integer.parseInt(scanner.nextLine())];
            for(int i = 0; i < businessTrips.length; i++) {
                String row = scanner.nextLine();
                if(row.isEmpty()){
                    businessTrips[i] = new BusinessTrip();
                } else {
                    String[] attr = row.split(";");
                    if(!attr[0].contains("crazy")) {
                        businessTrips[i] = new BusinessTrip(attr[0].trim(),
                                new Byn(Integer.parseInt(attr[1].trim())),
                                Integer.parseInt(attr[2].trim()));
                    } else i--;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        return businessTrips;
    }
}
