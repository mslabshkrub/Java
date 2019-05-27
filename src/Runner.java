import by.gsu.pms.model.BusinessTrip;
import by.gsu.pms.reader.BusinessTripReader;
import by.gsu.pms.service.BusinessTripService;
import by.gsu.pms.util.Printer;

public class Runner {
    public static void main(String[] args) {
        BusinessTripReader reader = new BusinessTripReader("src/", "in", ".txt");
        BusinessTrip[] trips = reader.read();
        BusinessTripService service = new BusinessTripService(trips);
        service.changeAccout(args[0], args[1]);
        service.sort();

        Printer.print(trips);
    }
}
