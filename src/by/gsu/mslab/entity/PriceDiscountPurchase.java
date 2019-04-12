package by.gsu.mslab.entity;

public class PriceDiscountPurchase extends GeneralPurchase {
    private Byn discount;

    public PriceDiscountPurchase() {
    }

    public PriceDiscountPurchase(String name, Byn price, int numOfUnits, Byn discount) {
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
        return super.fieldsToString() + ";"
                + discount;
    }
}
