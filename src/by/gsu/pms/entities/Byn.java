package by.gsu.pms.entities;

public class Byn {
    private final int value;

    public Byn() {
        this.value = 0;
    }

    public Byn(int value) {
        this.value = value;
    }

    public Byn add(Byn byn) {
        return new Byn(this.value + byn.value);
    }

    public Byn sub(Byn byn) {
        return new Byn(this.value - byn.value);
    }

    public Byn mult(double val) {
        return new Byn((int) (this.value * val));
    }

    public Byn div(double val) {
        return mult(1 / val);
    }

    public int compare(Byn byn) {
        return this.value - byn.value;
    }

    @Override
    public String toString() {
        int rubles = value / 100;
        int coins = value % 100;
        return rubles + "." + (coins / 10) + (coins % 10);
    }
}
