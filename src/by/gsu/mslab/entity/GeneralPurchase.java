package by.gsu.mslab.entity;

public class GeneralPurchase {
    private String name;
    private Byn price;
    private int numOfUnits;

    public GeneralPurchase() {
    }

    public GeneralPurchase(String name, Byn price, int numOfUnits) {
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

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof GeneralPurchase) {
            GeneralPurchase generalPurchase = (GeneralPurchase) obj;
            if (generalPurchase.name != null) {
                return this.name.equals(generalPurchase.name) && this.price.equals(generalPurchase.price);
            }
        }
        return false;
    }

    protected String fieldsToString() {
        return name + ";" +
                price + ";" +
                numOfUnits;
    }

    @Override
    public String toString(){
        return this.fieldsToString() + ";" +
                this.getCost();
    }
}
