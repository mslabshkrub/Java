package by.gsu.pms.sortClasses;

import by.gsu.pms.City;

import java.util.Comparator;

public class SortedBySquare implements Comparator<City> {

    @Override
    public int compare(City o1, City o2) {
        return (int) Math.ceil(o1.getSquare() - o2.getSquare());
    }
}
