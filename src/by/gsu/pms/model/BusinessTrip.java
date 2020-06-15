package by.gsu.pms.model;

public class BusinessTrip implements Comparable{
    private final Byn DAILY_ALLOWANCE_RATE;
    private String employeeAccount;
    private Byn transExp;
    private int numOfDays;

    public BusinessTrip() {
        DAILY_ALLOWANCE_RATE = new Byn(150);
        transExp = new Byn();
    }

    public BusinessTrip(Byn dailyAllowanceRate) {
        DAILY_ALLOWANCE_RATE = dailyAllowanceRate;
    }

    public BusinessTrip(String employeeAccount, Byn transExp, int numOfDay) {
        DAILY_ALLOWANCE_RATE = new Byn(150);
        this.employeeAccount = employeeAccount;
        this.transExp = transExp;
        this.numOfDays = numOfDay;
    }

    public String getEmployeeAccount() {
        return employeeAccount;
    }

    public void setEmployeeAccount(String employeeAccount) {
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


    @Override
    public int compareTo(Object o) {
        BusinessTrip b = (BusinessTrip) o;
        return getTotal().compare(b.getTotal());
    }
}
