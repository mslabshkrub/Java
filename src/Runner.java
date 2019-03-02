import by.gsu.pms.City;
import by.gsu.pms.sortClasses.SortedByName;
import by.gsu.pms.sortClasses.SortedByPopulation;
import by.gsu.pms.sortClasses.SortedBySquare;

import java.util.Arrays;
import java.util.Comparator;
import static by.gsu.pms.CityArrayAction.*;

public class Runner {
    private static void show(City[] cities, Comparator<City> cityComparator){
        System.out.println("***********************");
        City[] sortedCities = cities.clone();
        Arrays.sort(sortedCities, cityComparator);
        for(City city : sortedCities){
            System.out.println(city);
        }
    }

    public static void main(String[] args) {
        City[] cities = {
                new City("London", 8_673_713, 1572.15),
                new City("Mexico", 8_874_724, 1485.49),
                new City("New York", 8_550_405, 783.84),
                new City("Seul", 9_995_784, 605.21),
                new City("Tokio", 13_513_734, 2191),
                new City("Brest", 347_576, 146.12),
                new City("Mogilev", 381_553, 118.5),
                new City("Vitebsk", 317_960, 134.6),
                new City("Grodno", 370_919, 141.98),
                new City("Gomel", 535_693, 139.77)
        };

        System.out.printf("Total square = %.2f km^2 \n", getTotalSquare(cities));
        System.out.println("Number of cities with a population of more than one million = " + millionPopulationCount(cities));

        show(cities, new SortedByPopulation());
        show(cities, new SortedByName());
        show(cities, new SortedBySquare());
    }
}
