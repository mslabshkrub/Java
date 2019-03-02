package by.gsu.pms.sortClasses;

import by.gsu.pms.City;

import java.util.Comparator;

public class SortedByPopulation implements Comparator<City> {
    @Override
    public int compare(City o1, City o2) {
        return o1.getPopulation() - o2.getPopulation();
    }
}
