package by.gsu.pms.entities.Tax;

import by.gsu.pms.entities.Byn;

public class TaxAbroadTransfer extends TaxWithChildPrivileges{
    private static final double TAX_PERC = 0.25;
    private static final Byn ONE_CHILD_PRIVILEGE = new Byn(100);
    private static final Byn MANY_CHILD_PRIVILEGE = new Byn(150);

    public TaxAbroadTransfer(int childCount) {
        super.taxPerc = TAX_PERC;
        super.oneChildPrivilege = ONE_CHILD_PRIVILEGE;
        super.manyChildPrivilege = MANY_CHILD_PRIVILEGE;
        super.childCount = childCount;
    }
}
