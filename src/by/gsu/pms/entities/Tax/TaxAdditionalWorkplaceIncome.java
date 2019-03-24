package by.gsu.pms.entities.Tax;

import by.gsu.pms.entities.Byn;

public class TaxAdditionalWorkplaceIncome extends TaxWithChildPrivileges {
    private static final double TAX_PERC = 0.1;
    private static final Byn ONE_CHILD_PRIVILEGE = new Byn(200);
    private static final Byn MANY_CHILD_PRIVILEGE = new Byn(300);

    public TaxAdditionalWorkplaceIncome(int childCount) {
        super.taxPerc = TAX_PERC;
        super.oneChildPrivilege = ONE_CHILD_PRIVILEGE;
        super.manyChildPrivilege = MANY_CHILD_PRIVILEGE;
        super.childCount = childCount;
    }
}
