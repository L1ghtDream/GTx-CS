package dev.lightdream.gtxcs;

public class Dog extends Pet {

    private double droolRate;

    public Dog(String name, double health, int painLevel, double droolRate) {
        super(name, health, painLevel);
        if (droolRate <= 0) {
            droolRate = 0.5;
        }
        this.droolRate = droolRate;
    }

    public Dog(String name, double health, int painLevel) {
        this(name, health, painLevel, 5.0);
    }

    @Override
    public int treat() {
        int output;
        if (droolRate < 3.5) {
            output = (int) ((getPainLevel() * 2) / getHealth());
        } else if (droolRate <= 7.5) {
            output = (int) (getPainLevel() / getHealth());
        } else {
            output = (int) (getPainLevel() / (getHealth() * 2));
        }

        heal();
        return output;
    }

    @Override
    public void speak() {
        super.speak();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < getPainLevel(); i++) {
            str.append("bark ");
        }
        str.append(" ");
        str = new StringBuilder(str.toString()
                .replace("  ", ""));
        System.out.println(getPainLevel() > 5 ? str.toString()
                .toUpperCase() : str);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return droolRate == dog.droolRate && super.equals(o);
    }

    public double getDroolRate() {
        return droolRate;
    }
}
