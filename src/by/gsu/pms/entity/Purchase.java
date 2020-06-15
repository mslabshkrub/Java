package by.gsu.pms.entity;

public class Purchase implements Comparable{
    private String name;
    private Byn price;
    private int numOfUnits;

    public Purchase() {
    }

    public Purchase(String name, Byn price, int numOfUnits) {
        this.name = name;
        this.price = price;
        this.numOfUnits = numOfUnits;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byn getPrice() {
        return price;
    }

    public void setPrice(Byn price) {
        this.price = price;
    }

    public int getNumOfUnits() {
        return numOfUnits;
    }

    public void setNumOfUnits(int numOfUnits) {
        this.numOfUnits = numOfUnits;
    }

    public Byn getCost() {
        return price.mult(numOfUnits);
    }

    protected String fieldsToString() {
        return name + ";" +
                price + ";" +
                numOfUnits;
    }

    @Override
    public String toString() {
        return fieldsToString() + ";" + getCost();
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Purchase) {
            Purchase purchase = (Purchase) o;
            return getCost().compare(purchase.getCost());
        }
        return -1;
    }
}
