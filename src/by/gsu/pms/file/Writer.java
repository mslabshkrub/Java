package by.gsu.pms.file;

import by.gsu.pms.model.Airline;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Writer {
    private final String PATH;
    private final String FILE_NAME;
    private final String EXTENSION;

    public Writer(String path, String file_name, String extension) {
        PATH = path;
        FILE_NAME = file_name;
        EXTENSION = extension;
    }

    public void write(List<Airline> airlines) {
        try(FileWriter writer = new FileWriter(PATH + FILE_NAME + EXTENSION)) {
            for(Airline airline : airlines) {
                writer.write(airline.toString() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Cannot write into current file");
        }
    }
}
