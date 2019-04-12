import by.gsu.mslab.entity.Byn;
import by.gsu.mslab.entity.GeneralPurchase;
import by.gsu.mslab.reader.PurchaseReader;

public class Runner {
    public static void main(String[] args) {
        GeneralPurchase[] generalPurchases = PurchaseReader.read("src/in.txt");
        boolean isEquals = true;
        Byn maxCost = generalPurchases[0].getCost();
        GeneralPurchase maxCostPurchase = generalPurchases[0];
        for(GeneralPurchase generalPurchase : generalPurchases) {
            System.out.println(generalPurchase);
            if(isEquals) {
                isEquals = generalPurchase.equals(generalPurchases[0]);
            }
            if (maxCost.compare(generalPurchase.getCost()) < 0) {
                maxCost = generalPurchase.getCost();
                maxCostPurchase = generalPurchase;
            }
        }

        System.out.println("Max cost purchase: " + maxCostPurchase);
        System.out.println("All purchases are equal: " + isEquals);
    }
}
