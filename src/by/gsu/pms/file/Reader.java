package by.gsu.pms.file;

import by.gsu.pms.model.AircraftType;
import by.gsu.pms.model.Airline;
import by.gsu.pms.model.Day;
import by.gsu.pms.model.Time;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Reader {
    private final String PATH;
    private final String FILE_NAME;
    private final String EXTENSION;

    public Reader(String path, String file_name, String extension) {
        PATH = path;
        FILE_NAME = file_name;
        EXTENSION = extension;
    }

    public List<Airline> read() {
        Scanner scanner = null;
        List<Airline> airlines = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(PATH + FILE_NAME + EXTENSION);
            scanner = new Scanner(fileReader);

            while (scanner.hasNextLine()) {
                String row = scanner.nextLine();
                String[] vals = row.split(";");
                String flightNum = vals[0];
                String destination = vals[1];
                AircraftType aircraftType = AircraftType.valueOf(vals[2].toUpperCase());
                Time time = new Time(vals[3]);
                Set<Day> daySet = new HashSet<>();
                String[] days = vals[4].split(",");
                for(String day : days) {
                    daySet.add(Day.valueOf(day.toUpperCase()));
                }

                airlines.add(new Airline(destination, flightNum, aircraftType, time, daySet));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Cannot find current file");
        } finally {
            if(scanner != null) {
                scanner.close();
            }
        }
        return airlines;
    }
}
