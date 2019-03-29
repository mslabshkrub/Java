package by.gsu.pms.entities.Tax;

import by.gsu.pms.entities.Byn;

public abstract class TaxWithChildPrivileges extends Tax{
    Byn oneChildPrivilege;
    Byn manyChildPrivilege;
    int childCount;

    @Override
    public Byn getTotal(Byn byn){
        Byn taxVal = super.getTotal(byn);
        if (childCount > 1){
            return taxVal.sub((manyChildPrivilege.mult(childCount)).mult(super.taxPerc));
        }
        return oneChildPrivilege.sub((oneChildPrivilege.mult(childCount)).mult(super.taxPerc));
    }
}
