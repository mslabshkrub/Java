package by.gsu.pms;

public class CityArrayAction {
    public static double getTotalSquare(City[] cities){
        double sum = 0;
        for (City city : cities){
            sum += city.getSquare();
        }
        return sum;
    }

    public static int millionPopulationCount(City[] cities){
        int count = 0;
        for (City city : cities){
            if (city.getPopulation() > 1_000_000){
                count++;
            }
        }
        return count;
    }
}
