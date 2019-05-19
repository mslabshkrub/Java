import by.gsu.pms.entity.Byn;
import by.gsu.pms.entity.Purchase;
import by.gsu.pms.reader.PurchaseReader;
import by.gsu.pms.service.PurchaseService;

import java.util.List;

import static by.gsu.pms.util.Printer.printAll;
import static by.gsu.pms.util.Printer.printByIndex;

public class Runner {

    public static void main(String[] args) {
        PurchaseReader reader = new PurchaseReader("src/", "in", ".csv");
        List<Purchase> purchases = reader.read();
        PurchaseService service = new PurchaseService(purchases);

        printAll(purchases);
        printByIndex(purchases, 6);
        service.removeIf(purchase -> purchase.getPrice().compare(new Byn(100)) < 1);
        service.sort();
        printAll(purchases);
        service.findByPrice(new Byn(350));
    }
}
