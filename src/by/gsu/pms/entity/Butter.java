package by.gsu.pms.entity;

import java.io.Serializable;

public class Butter implements Serializable {
    private String name;
    private boolean isHerbalSupplements;
    private Byn price;

    public Butter() {
    }

    public Butter(String name, boolean isHerbalSupplements, Byn price) {
        this.name = name;
        this.isHerbalSupplements = isHerbalSupplements;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHerbalSupplements() {
        return isHerbalSupplements;
    }

    public void setHerbalSupplements(boolean herbalSupplements) {
        isHerbalSupplements = herbalSupplements;
    }

    public Byn getPrice() {
        return price;
    }

    public void setPrice(Byn price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Butter{" +
                "name='" + name + '\'' +
                ", isHerbalSupplements=" + isHerbalSupplements +
                ", price=" + price +
                '}';
    }
}
