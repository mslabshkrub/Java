import by.gsu.pms.menu.Menu;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Menu menu = Menu.getInstance();
        while (true) {
            menu.getMainPage();
            Scanner scanner = new Scanner(System.in);
            System.out.println();
            String button = scanner.next();
            if(NumberUtils.isDigits(button)){
                menu.getPageWithTaxes(Integer.parseInt(button), scanner);
            }
            else{
                switch (button){
                    case ("c"):
                        menu.chooseCreatingPage(scanner);
                        break;
                    case ("q"):
                        return;
                    case ("d"):
                        menu.deleteUserPage(scanner);
                        break;
                }
            }
        }
    }
}
