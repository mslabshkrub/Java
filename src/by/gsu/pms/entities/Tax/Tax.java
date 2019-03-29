package by.gsu.pms.entities.Tax;

import by.gsu.pms.entities.Byn;

public abstract class Tax {
    double taxPerc;

    public Byn getTotal(Byn byn){
        return byn.mult(taxPerc);
    }
}
