package by.gsu.pms.logic;

import by.gsu.pms.entities.Byn;
import by.gsu.pms.entities.Tax.*;
import by.gsu.pms.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaxesAction {
    private List<Byn> taxAbroadTransfers = new ArrayList<>();
    private List<Byn> taxGifts = new ArrayList<>();
    private List<Byn> taxPropertySales = new ArrayList<>();
    private List<Byn> taxRoyalties = new ArrayList<>();
    private Byn taxMainWorplaceIncome;
    private Byn taxAdditionalWorkplaceIncome;

    private User user;

    public TaxesAction(User user) {
        this.user = user;
    }

    private void calculateAllTaxesForUser() {
        Byn mainWorkplaceIncome = user.getMainWorkplaceIncome();
        Byn additionalWOrkplaceIncome = user.getAdditionalWorkplaceIncome();
        List<Byn> abroadTransfers = user.getAbroadTransfers();
        List<Byn> gifts = user.getGifts();
        List<Byn> propertySales = user.getPropertySale();
        List<Byn> royalties = user.getRoyalties();

        int childCount = user.getChildCount();

        Tax tax = new TaxMainWorkplaceIncome(childCount);
        taxMainWorplaceIncome = tax.getTotal(mainWorkplaceIncome);

        if (user.getAdditionalWorkplaceIncome() != null) {
            tax = new TaxAdditionalWorkplaceIncome(childCount);
            taxAdditionalWorkplaceIncome = tax.getTotal(additionalWOrkplaceIncome);

            for (Byn byn : abroadTransfers) {
                tax = new TaxAbroadTransfer(childCount);
                taxAbroadTransfers.add(tax.getTotal(byn));
            }

            for (Byn byn : gifts) {
                tax = new TaxGifts();
                taxGifts.add(tax.getTotal(byn));
            }

            for (Byn byn : propertySales) {
                tax = new TaxPropertySale(childCount);
                taxPropertySales.add(tax.getTotal(byn));
            }

            for (Byn byn : royalties) {
                tax = new TaxRoyalties();
                taxRoyalties.add(tax.getTotal(byn));
            }
        }

    }

    private Byn sumTaxes(List<Byn> byns) {
        final Byn[] sum = {new Byn()};
        byns.forEach(e -> sum[0] = sum[0].add(e));
        return sum[0];
    }

    public void printAllTaxesForUser(Scanner scanner) {
        calculateAllTaxesForUser();
        System.out.println("For " + user.getLastName() + " " + user.getFirstName());
        System.out.println("Main workplace income taxes: " + taxMainWorplaceIncome.mult(12));
        if (user.getAbroadTransfers() != null) {
            System.out.println("Additional workplace income taxes: " + taxAdditionalWorkplaceIncome.mult(12));
            System.out.println("Abroad transfer taxes: " + sumTaxes(taxAbroadTransfers));
            System.out.println("Gift taxes: " + sumTaxes(taxGifts));
            System.out.println("Property sale taxes: " + sumTaxes(taxPropertySales));
            System.out.println("Royalty taxes: " + sumTaxes(taxRoyalties));
        }
        System.out.println("*********");
        System.out.println("(m) - Main page");
        System.out.println("(d) - More details");
        String button = scanner.next();
        switch (button) {
            case ("m"):
                return;
            case ("d"):
                printDetails();
                break;
        }
    }

    private void printDetails(){
        System.out.println("Main workplace income taxes: ");
        for(int i = 0; i < 12; i++){
            System.out.println("- " + taxMainWorplaceIncome);
        }

        int workplaceTaxesCount = 12;

        if (user.getAbroadTransfers() != null) {
            workplaceTaxesCount += 12;
            System.out.println("Additional workplace income taxes: ");
            for(int i = 0; i < 12; i++){
                System.out.println("- " + taxAdditionalWorkplaceIncome);
            }
            System.out.println("Abroad transfer taxes: ");
            printTaxes(taxAbroadTransfers);
            System.out.println("Gift taxes: ");
            printTaxes(taxGifts);
            System.out.println("Property sale taxes: ");
            printTaxes(taxPropertySales);
            System.out.println("Royalty taxes: ");
            printTaxes(taxRoyalties);
        }
        System.out.println("Taxes count: " + (taxRoyalties.size() + taxPropertySales.size() +
                taxGifts.size() + taxAbroadTransfers.size() + workplaceTaxesCount));
        System.out.println();
    }

    private void printTaxes(List<Byn> byns){
        for(Byn byn : byns){
            System.out.println("- " + byn);
        }
    }
}
