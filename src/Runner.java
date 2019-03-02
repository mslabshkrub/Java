import by.gsu.asoilab.Account;
import by.gsu.asoilab.BusinessTrip;
import by.gsu.asoilab.Byn;

public class Runner {
    private static void printDuration(BusinessTrip... businessTrips){
        for (BusinessTrip businessTrip : businessTrips){
            System.out.println("Duration = " + businessTrip.getNumOfDays());
        }
        System.out.println();
    }

    private static void print(BusinessTrip[] businessTrips){
        for (BusinessTrip businessTrip : businessTrips){
            System.out.println(businessTrip);
        }
    }

    private static Byn getSumOfExpenses(BusinessTrip[] businessTrips){
        Byn byn = new Byn();
        for (BusinessTrip businessTrip : businessTrips){
            if (businessTrip != null){
                byn = byn.add(businessTrip.getTotal());
            }
        }

        return byn;
    }

    private static void findAccountWithMaxExp(BusinessTrip[] businessTrips){
        Byn maxByn = new Byn();
        Account account = new Account();
        for(BusinessTrip businessTrip : businessTrips){
            if (businessTrip != null){
                if (maxByn.compare(businessTrip.getTotal()) < 0){
                    maxByn = businessTrip.getTotal();
                    account = businessTrip.getEmployeeAccount();
                }
            }
        }
        System.out.println("\n" + account);
    }

    public static void main(String[] args) {
        BusinessTrip[] businessTrips = {
                new BusinessTrip(new Account("Vlad", "Shkrabkov"), new Byn(600), 5),
                new BusinessTrip(new Account("Phill", "Yurkovsky"), new Byn(550), 10),
                null,
                new BusinessTrip(new Account("Andre", "Yaros"), new Byn(601), 8),
                new BusinessTrip(new Account("John", "Jones"), new Byn(564), 13),
                new BusinessTrip(new Account("Alex", "Yedder"), new Byn(764), 4),
                new BusinessTrip()
        };

        for (BusinessTrip businessTrip : businessTrips){
            if (businessTrip == null){
                System.out.println("null" + "\n");
            }
            else{
                businessTrip.show();
            }
        }

        businessTrips[businessTrips.length - 1].setTransExp(new Byn(123));

        printDuration(businessTrips[1], businessTrips[5]);

        print(businessTrips);

        System.out.println("\nSum of expenses = " + getSumOfExpenses(businessTrips));
        findAccountWithMaxExp(businessTrips);
    }
}
