package by.gsu.pms.entities;

import java.util.List;

public class User {
    private String firstName;
    private String lastName;
    private Byn mainWorkplaceIncome;
    private Byn additionalWorkplaceIncome;
    private List<Byn> royalties;
    private List<Byn> propertySales;
    private List<Byn> gifts;
    private List<Byn> abroadTransfers;
    private int childCount;

    public User() {
    }

    public User(String firstName, String lastName, Byn mainWorkplaceIncome, Byn additionalWorkplaceIncome,
                List<Byn> royalties, List<Byn> propertySales, List<Byn> gifts,
                List<Byn> abroadTransfers, int childCount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mainWorkplaceIncome = mainWorkplaceIncome;
        this.additionalWorkplaceIncome = additionalWorkplaceIncome;
        this.royalties = royalties;
        this.propertySales = propertySales;
        this.gifts = gifts;
        this.abroadTransfers = abroadTransfers;
        this.childCount = childCount;
    }

    public User(String firstName, String lastName, Byn mainWorkplaceIncome, int childCount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mainWorkplaceIncome = mainWorkplaceIncome;
        this.childCount = childCount;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Byn getMainWorkplaceIncome() {
        return mainWorkplaceIncome;
    }

    public Byn getAdditionalWorkplaceIncome() {
        return additionalWorkplaceIncome;
    }

    public List<Byn> getRoyalties() {
        return royalties;
    }

    public List<Byn> getPropertySale() {
        return propertySales;
    }

    public List<Byn> getGifts() {
        return gifts;
    }

    public List<Byn> getAbroadTransfers() {
        return abroadTransfers;
    }

    public int getChildCount() {
        return childCount;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMainWorkplaceIncome(Byn mainWorkplaceIncome) {
        this.mainWorkplaceIncome = mainWorkplaceIncome;
    }

    public void setAdditionalWorkplaceIncome(Byn additionalWorkplaceIncome) {
        this.additionalWorkplaceIncome = additionalWorkplaceIncome;
    }

    public void setRoyalties(List<Byn> royalties) {
        this.royalties = royalties;
    }

    public void setPropertySales(List<Byn> propertySales) {
        this.propertySales = propertySales;
    }

    public void setGifts(List<Byn> gifts) {
        this.gifts = gifts;
    }

    public void setAbroadTransfers(List<Byn> abroadTransfers) {
        this.abroadTransfers = abroadTransfers;
    }

    public void setChildCount(int childCount) {
        this.childCount = childCount;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mainWorkplaceIncome=" + mainWorkplaceIncome +
                ", additionalWorkplaceIncome=" + additionalWorkplaceIncome +
                ", royalties=" + royalties +
                ", propertySales=" + propertySales +
                ", gifts=" + gifts +
                ", abroadTransfers=" + abroadTransfers +
                ", childCount=" + childCount +
                '}';
    }
}
