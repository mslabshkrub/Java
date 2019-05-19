package by.gsu.pms.menu;

import by.gsu.pms.entity.Butter;
import by.gsu.pms.entity.Byn;
import by.gsu.pms.service.ButterService;
import by.gsu.pms.util.Printer;
import by.gsu.pms.util.Serializator;

import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private enum Button{
        ADD, SERIALIZATION, DESERIALIZATION, PRINT,  TOTAL_COST, HERBAL_SUPPLEMENTS_COUNT, EXIT
    }

    private Scanner scanner = new Scanner(System.in);

    private static Menu ourInstance = new Menu();

    public static Menu getInstance() {
        return ourInstance;
    }

    private Menu() {
    }

    public void showMainPage() {
        boolean status = true;
        Action action = new Action();
        while (status) {
            System.out.println("-------------------");
            System.out.println("1 - Add new Butter");
            System.out.println("2 - Serialization");
            System.out.println("3 - Deserialization");
            System.out.println("4 - Print");
            System.out.println("5 - Total cost");
            System.out.println("6 - Herbal supplements count");
            System.out.println("7 - Exit");
            System.out.println("-------------------");

            Button button = Button.values()[scanner.nextInt() - 1];
            switch (button) {
                case ADD:
                    showAddMenu(action);
                    break;
                case SERIALIZATION:
                    action.serialization();
                    break;
                case DESERIALIZATION:
                    action.deserialization();
                    break;
                case TOTAL_COST:
                    action.totalCost();
                    break;
                case HERBAL_SUPPLEMENTS_COUNT:
                    action.herbalSupplementsCount();
                    break;
                case PRINT:
                    action.print();
                    break;
                case EXIT:
                    status = false;
                    scanner.close();
                    break;
            }
        }
    }

    private static class Action {
        private List<Butter> butters = new ArrayList<>();

        private static final String FILE_NAME = "in.data";

        private ButterService service = new ButterService(butters);

        void serialization() {
            Serializator.serialization(butters, FILE_NAME);
        }

        void deserialization() {
            try {
                butters = Serializator.deserialization(FILE_NAME);
                service.setButters(butters);
            } catch (InvalidObjectException e) {
                e.printStackTrace();
            }
        }

        void totalCost() {
            System.out.println("Total cost - " + service.totalCost());
        }

        void herbalSupplementsCount() {
            System.out.println("Herbal supplements count - " + service.herbalSupplementsCount());
        }

        void print() {
            Printer.print(butters);
        }

        void addNew(String name, int price, boolean isHerbalSupplements) {
            butters.add(new Butter(name, isHerbalSupplements, new Byn(price)));
        }
    }

    private void showAddMenu(Action action) {
        boolean status = true;
        String name;
        int price;
        boolean isHerbalSupplements;
        while (status) {
            System.out.println("Name: ");
            name = scanner.next();
            System.out.println("Price: ");
            price = scanner.nextInt();
            System.out.println("Herbal supplements");
            isHerbalSupplements = scanner.nextBoolean();
            action.addNew(name, price, isHerbalSupplements);

            System.out.println("-------------------");
            System.out.println("1 - Add new");
            System.out.println("7 - Exit");
            System.out.println("-------------------");

            Button button = Button.values()[scanner.nextInt() - 1];
            switch (button) {
                case ADD:
                    break;
                case EXIT:
                    status = false;
            }
        }
    }
}
