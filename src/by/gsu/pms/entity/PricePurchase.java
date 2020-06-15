package by.gsu.pms.entity;

public class PricePurchase extends Purchase{
    private Byn discount;

    public PricePurchase() {
    }

    public PricePurchase(Byn discount) {
        this.discount = discount;
    }

    public PricePurchase(String name, Byn price, int numOfUnits, Byn discount) {
        super(name, price, numOfUnits);
        this.discount = discount;
    }

    public Byn getDiscount() {
        return discount;
    }

    public void setDiscount(Byn discount) {
        this.discount = discount;
    }

    @Override
    public Byn getCost() {
        return super.getCost().sub(discount.mult(super.getNumOfUnits()));
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + ";" + discount;
    }
}
