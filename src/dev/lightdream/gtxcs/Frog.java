package dev.lightdream.gtxcs;

public class Frog {

    private static String species = "Rare Pepe";
    private String name;
    public boolean isFroglet;
    private int age;
    private double tongueSpeed;

    public Frog(String name, int age, double tongueSpeed) {
        this.name = name;
        this.age = age;
        this.tongueSpeed = tongueSpeed;

        isFroglet = age > 1 && age < 7;
    }

    public Frog(String name, double ageInYears, double tongueSpeed) {
        this(name, (int) ageInYears * 12, tongueSpeed);
    }

    public Frog(String name) {
        this(name, 5, 5);
    }

    @SuppressWarnings("unused")
    public static String getSpecies() {
        return species;
    }

    public static void setSpecies(String species) {
        Frog.species = species;
    }

    public void grow(int grow) {
        for (int i = 0; i < grow; i++) {
            this.age++;
            if (this.age <= 12) {
                this.tongueSpeed++;
            }
            if (this.age > 30) {
                tongueSpeed--;
            }
        }

        if (tongueSpeed < 5) {
            this.tongueSpeed = 5;
        }

        this.isFroglet = age > 1 && age < 7;
    }

    public void grow() {
        grow(1);
    }

    public void eat(Fly fly) {
        if (fly.isDead() || fly.getSpeed() > this.tongueSpeed || fly.getMass() < this.age / 2.0) {
            fly.grow(1);
            return;
        }
        grow();
        fly.setMass(0);
    }

    @Override
    public String toString() {
        if (isFroglet) {
            return String.format("My name is %s and I’m a rare froglet! I’m %d months old and my tongue has a speed of %.2f.", name, age, tongueSpeed);
        }
        return String.format("My name is %s and I’m a rare frog. I’m %d months old and my tongue has a speed of %.2f.", name, age, tongueSpeed);

    }
}
