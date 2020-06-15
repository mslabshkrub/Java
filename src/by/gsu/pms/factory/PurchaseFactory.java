package by.gsu.pms.factory;

import by.gsu.pms.entity.Byn;
import by.gsu.pms.entity.PricePurchase;
import by.gsu.pms.entity.Purchase;

public class PurchaseFactory {
    public static Purchase getClassFromFactory(String row) {
        String[] attributes = row.split(";");

        String name = attributes[0];
        Byn price = new Byn(Integer.parseInt(attributes[1]));
        int numOfUnits = Integer.parseInt(attributes[2]);

        if(attributes.length == 4) {
            Byn discount = new Byn(Integer.parseInt(attributes[3]));
            return new PricePurchase(name, price, numOfUnits, discount);
        }

        return new Purchase(name, price, numOfUnits);
    }
}
