package by.gsu.pms;

public class City{
    private String name;
    private int population;
    private double square;

    public City() {
    }

    public City(String name, int population, double square) {
        this.name = name;
        this.population = population;
        this.square = square;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    @Override
    public String toString(){
        return name + ";" +
                population + ";" +
                square;
    }
}
