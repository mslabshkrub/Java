package by.gsu.pms.reader;

import by.gsu.pms.factory.BusinessTripFactory;
import by.gsu.pms.model.BusinessTrip;
import by.gsu.pms.reader.parser.Parser;
import by.gsu.pms.reader.parser.ParserFactory;
import by.gsu.pms.reader.parser.exception.UnsupportedParserTypeException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class BusinessTripReader {
    private final String PATH;
    private final String FILE_NAME;
    private final String EXTENSION;

    public BusinessTripReader(String path, String file_name, String extension) {
        PATH = path;
        FILE_NAME = file_name;
        EXTENSION = extension;
    }

    public BusinessTrip[] read() {
        Scanner scanner = null;
        BusinessTrip[] businessTrips = new BusinessTrip[10];

        try {
            FileReader fileReader = new FileReader(PATH + FILE_NAME + EXTENSION);
            scanner = new Scanner(fileReader);

            while (scanner.hasNextLine()) {
                String row = scanner.nextLine() + " ";
                String[] attr = row.split("=");
                BusinessTrip businessTrip = new BusinessTrip();
                try {
                    Parser parser = ParserFactory.getParser(attr[0].trim());
                    parser.parse(attr[0].trim(), attr[1].trim());
                    businessTrips = BusinessTripFactory.getInstance().toArray();
                } catch (UnsupportedParserTypeException e) {
                    System.err.println(e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(scanner != null) {
                scanner.close();
            }
            BusinessTripFactory.getInstance().clear();
        }
        return businessTrips;
    }
}
