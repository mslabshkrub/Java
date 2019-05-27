import by.gsu.pms.model.BusinessTrip;
import by.gsu.pms.reader.BusinessTripReaderCsv;
import by.gsu.pms.service.BusinessTripService;
import by.gsu.pms.util.Printer;

public class Runner {
    public static void main(String[] args) {
        BusinessTripReaderCsv reader = new BusinessTripReaderCsv("src/", "in", ".csv");
        BusinessTrip[] trips = reader.read();
        BusinessTripService service = new BusinessTripService(trips);
        service.sort();

        Printer.print(trips);
    }
}
