package by.gsu.mslab.entity;

public class PercentDiscountPurchase extends GeneralPurchase{
    private static final int FIXED_NUM_OF_UNITS = 7;
    private double discount;

    public PercentDiscountPurchase(double discount) {
    }

    public PercentDiscountPurchase(String name, Byn price, int numOfUnits, double discount) {
        super(name, price, numOfUnits);
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + ";" +
                FIXED_NUM_OF_UNITS + ";" +
                discount;
    }

    @Override
    public Byn getCost() {
        if(getNumOfUnits() > FIXED_NUM_OF_UNITS) {
            return getPrice().mult(getNumOfUnits()).mult(1 - (discount/100));
        }
        return super.getCost();
    }
}
