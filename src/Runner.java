import by.gsu.pms.file.Reader;
import by.gsu.pms.file.Writer;
import by.gsu.pms.model.Airline;
import by.gsu.pms.model.Day;
import by.gsu.pms.model.Time;
import by.gsu.pms.service.AirlineService;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        Reader reader = new Reader("src/", "in", ".csv");
        Writer writer = new Writer("src/", "out", ".txt");

        List<Airline> airlines = reader.read();
        AirlineService service = new AirlineService(airlines);
        service.findByDestination("London");
        service.findByDay(Day.SUNDAY);
        service.findByDayAndTimeAfter(Day.MONDAY, new Time("12:30 PM"));

        service.sort();

        writer.write(airlines);
    }
}
