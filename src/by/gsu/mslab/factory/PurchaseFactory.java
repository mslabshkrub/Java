package by.gsu.mslab.factory;

import by.gsu.mslab.entity.Byn;
import by.gsu.mslab.entity.GeneralPurchase;
import by.gsu.mslab.entity.PercentDiscountPurchase;
import by.gsu.mslab.entity.PriceDiscountPurchase;

import java.util.Scanner;

public class PurchaseFactory {
    private enum PurchaseKinds {
        GENERAL_PURCHASE, PRICE_DISCOUNT_PURCHASE, PERCENT_DISCOUNT_PURCHASE
    }

    public static GeneralPurchase getClassFromFactory(Scanner scanner) {
        String id = scanner.next();
        String name = scanner.next();
        Byn price = new Byn(Integer.parseInt(scanner.next()));
        int numOfUnits = Integer.parseInt(scanner.next());

        PurchaseKinds kind = PurchaseKinds.valueOf(id);
        switch (kind) {
            case GENERAL_PURCHASE:
                return new GeneralPurchase(name, price, numOfUnits);
            case PRICE_DISCOUNT_PURCHASE:
                return new PriceDiscountPurchase(name, price, numOfUnits, new Byn(Integer.parseInt(scanner.next())));
            case PERCENT_DISCOUNT_PURCHASE:
                return new PercentDiscountPurchase(name, price, numOfUnits, Double.parseDouble(scanner.next()));
        }
        return null;
    }
}
