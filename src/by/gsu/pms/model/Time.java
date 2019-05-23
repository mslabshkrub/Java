package by.gsu.pms.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Time implements Comparable{

    private Date time;
    private DateFormat dateFormat = new SimpleDateFormat("hh:mm a");

    public Time(String time) {
        try {
            this.time = dateFormat.parse(time);
        } catch (ParseException e) {
            System.err.println("Wrong time format");
        }
    }

    @Override
    public String toString() {
        return dateFormat.format(time);
    }

    @Override
    public int compareTo(Object o) {
        Time t = (Time) o;
        return time.compareTo(t.time);
    }
}
