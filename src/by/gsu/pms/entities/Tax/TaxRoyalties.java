package by.gsu.pms.entities.Tax;

public class TaxRoyalties extends Tax{
    private final static double TAX_PERC = 0.2;

    public TaxRoyalties() {
        super.taxPerc = TAX_PERC;
    }
}
