package by.gsu.pms.service;

import by.gsu.pms.model.BusinessTrip;

import java.util.Arrays;

public class BusinessTripService {
    private BusinessTrip[] businessTrips;

    public BusinessTripService(BusinessTrip[] businessTrips) {
        this.businessTrips = businessTrips;
    }

    public void sort() {
        Arrays.sort(businessTrips);
    }
}
