package by.gsu.pms.service;

import by.gsu.pms.model.Airline;
import by.gsu.pms.model.Day;
import by.gsu.pms.model.Time;
import by.gsu.pms.util.Printer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AirlineService {
    private List<Airline> airlines;

    public AirlineService(List<Airline> airlines) {
        this.airlines = airlines;
    }

    public void findByDestination(String destination) {
        List<Airline> copy = new ArrayList<>(airlines);
        Printer.print(copy.stream().filter(a -> a.getDestination().equals(destination)).collect(Collectors.toList()));
    }

    public void findByDay(Day day) {
        List<Airline> copy = new ArrayList<>(airlines);
        Printer.print(copy.stream().filter(airline -> airline.getDays().contains(day)).collect(Collectors.toList()));
    }

    public void findByDayAndTimeAfter(Day day, Time time) {
        List<Airline> copy = new ArrayList<>(airlines);
        Printer.print(copy.stream().filter(airline -> airline.getDays().contains(day))
                .filter(airline -> airline.getDepartureTime().compareTo(time) > 0)
                .collect(Collectors.toList()));
    }

    public void sort() {
        Collections.sort(airlines);
    }
}