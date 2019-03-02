package by.gsu.asoilab;

public class BusinessTrip {
    private final static Byn DAILY_ALLOWANCE_RATE = new Byn(2356);
    private Account employeeAccount;
    private Byn transExp;
    private int numOfDays;

    public BusinessTrip() {
        employeeAccount = new Account();
        transExp = new Byn();
    }

    public BusinessTrip(Account employeeAccount, Byn transExp, int numOfDay) {
        this.employeeAccount = employeeAccount;
        this.transExp = transExp;
        this.numOfDays = numOfDay;
    }

    public Account getEmployeeAccount() {
        return employeeAccount;
    }

    public void setEmployeeAccount(Account employeeAccount) {
        this.employeeAccount = employeeAccount;
    }

    public Byn getTransExp() {
        return transExp;
    }

    public void setTransExp(Byn transExp) {
        this.transExp = transExp;
    }

    public int getNumOfDays() {
        return numOfDays;
    }

    public void setNumOfDays(int numOfDays) {
        this.numOfDays = numOfDays;
    }

    public Byn getTotal(){
        return transExp.add(DAILY_ALLOWANCE_RATE.mult(numOfDays));
    }

    public void show(){
        System.out.println("rate = " + DAILY_ALLOWANCE_RATE);
        System.out.println("account = " + employeeAccount);
        System.out.println("transport = " + transExp);
        System.out.println("days = " + numOfDays);
        System.out.println("total = " + getTotal() + "\n");
    }

    @Override
    public String toString(){
        return DAILY_ALLOWANCE_RATE + ";" +
                employeeAccount + ";" +
                transExp + ";" +
                numOfDays + ";" +
                getTotal();
    }
}
