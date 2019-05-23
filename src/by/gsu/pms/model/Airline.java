package by.gsu.pms.model;

import java.util.Set;

public class Airline implements Comparable{
    private String destination;
    private String flightNum;
    private AircraftType aircraftType;
    private Time departureTime;
    private Set<Day> days;

    public Airline() {
    }

    public Airline(String destination, String flightNum, AircraftType aircraftType, Time departureTime, Set<Day> days) {
        this.destination = destination;
        this.flightNum = flightNum;
        this.aircraftType = aircraftType;
        this.departureTime = departureTime;
        this.days = days;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(String flightNum) {
        this.flightNum = flightNum;
    }

    public AircraftType getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(AircraftType aircraftType) {
        this.aircraftType = aircraftType;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public Set<Day> getDays() {
        return days;
    }

    public void setDays(Set<Day> days) {
        this.days = days;
    }

    @Override
    public int compareTo(Object o) {
        Airline airline = (Airline) o;
        return this.flightNum.compareTo(airline.flightNum);
    }

    @Override
    public String toString() {
        return "Airline{" +
                "destination='" + destination + '\'' +
                ", flightNum='" + flightNum + '\'' +
                ", aircraftType=" + aircraftType +
                ", departureTime=" + departureTime +
                ", days=" + days +
                '}';
    }
}
