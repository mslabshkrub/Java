package by.gsu.pms.entities.Tax;

public class TaxGifts extends Tax{
    private static final double TAX_PERC = 0.05;

    public TaxGifts() {
        super.taxPerc = TAX_PERC;
    }
}
