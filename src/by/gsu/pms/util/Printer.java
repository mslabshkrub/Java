package by.gsu.pms.util;

import by.gsu.pms.model.BusinessTrip;

public class Printer {
    public static void print(BusinessTrip[] businessTrips) {
        for(BusinessTrip businessTrip : businessTrips) {
            businessTrip.show();
        }
    }
}
