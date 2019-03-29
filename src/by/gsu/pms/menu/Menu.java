package by.gsu.pms.menu;

import by.gsu.pms.entities.Byn;
import by.gsu.pms.entities.User;
import by.gsu.pms.json.UserMap;
import by.gsu.pms.logic.TaxesAction;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.*;

public class Menu {
    private static Menu ourInstance = new Menu();

    private UserMap userMap = UserMap.getInstance();

    public static Menu getInstance() {
        return ourInstance;
    }

    private Menu() {
    }

    public void getMainPage() {
        userMap.printAll();
        System.out.println("*********************");
        System.out.println("Id of user to getting taxes info");
        System.out.println("(c) - Create new User");
        System.out.println("(q) - Quit");
        System.out.println("(d) - Delete user");
    }

    public void getPageWithTaxes(long id, Scanner scanner){
        User user = userMap.getUser(id);
        TaxesAction taxesAction = new TaxesAction(user);
        taxesAction.printAllTaxesForUser(scanner);
    }

    public void chooseCreatingPage(Scanner scanner){
        System.out.println("Choose creating form for user");
        System.out.println("(e) - Extended form");
        System.out.println("(b) - Base form");
        System.out.println();
        String button = scanner.next();
        switch (button){
            case ("e"):
                getCreateUserExtendedPage(scanner);
                break;
            case ("b"):
                getCreateUserBasePage(scanner);
                break;
        }
    }

    private void commonForm(Scanner scanner, User user){
        System.out.println("First name: ");
        String firstName = scanner.next();
        System.out.println("Last name: ");
        String lastName = scanner.next();
        System.out.println("Main workplace income: ");
        int val = scanner.nextInt();
        Byn mainWorkplaceIncome = new Byn(val);
        System.out.println("Child count: ");
        int childCount = scanner.nextInt();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setMainWorkplaceIncome(mainWorkplaceIncome);
        user.setChildCount(childCount);
    }

    private void getCreateUserBasePage(Scanner scanner){
        User user = new User();
        commonForm(scanner, user);
        userMap.addUser(user);
    }

    private void getCreateUserExtendedPage(Scanner scanner){
        User user = new User();
        commonForm(scanner, user);

        System.out.println("Additional workplace income: ");
        int val = scanner.nextInt();
        Byn additionalWorkplaceIncome = new Byn(val);
        List<Byn> royalties = new ArrayList<>();
        cycleInput(royalties, "Royalties: ", scanner);
        List<Byn> propertySales = new ArrayList<>();
        cycleInput(propertySales, "Property sales: ", scanner);
        List<Byn> gifts = new ArrayList<>();
        cycleInput(gifts, "Gifts: ", scanner);
        List<Byn> abroadTranfers = new ArrayList<>();
        cycleInput(abroadTranfers, "Abroad transfers: ", scanner);

        user.setRoyalties(royalties);
        user.setAdditionalWorkplaceIncome(additionalWorkplaceIncome);
        user.setPropertySales(propertySales);
        user.setGifts(gifts);
        user.setAbroadTransfers(abroadTranfers);

        userMap.addUser(user);
    }

    private void cycleInput(List<Byn> byns, String output, Scanner scanner){
        System.out.println(output);
        int count = 0;
        while (true) {
            System.out.println("(a) - Add new");
            System.out.println("(q) - Quit");
            System.out.println("*************");
            String button = scanner.next();
            switch (button) {
                case ("q"):
                    return;
                case ("a"):
                    break;
            }
            System.out.print(++count + ") ");
            int val = scanner.nextInt();
            byns.add(new Byn(val));
        }
    }

    public void deleteUserPage(Scanner scanner){
        while (true){
            userMap.printAll();
            System.out.println("*************");
            System.out.println("(q) - Quit");
            System.out.println("Enter id of user for deleting");
            String button = scanner.next();
            if(NumberUtils.isDigits(button)){
                userMap.deleteUser(Long.parseLong(button));
            }
            if(button.equals("q")){
                return;
            }
        }

    }
}
