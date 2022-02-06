package dev.lightdream.gtxcs;

public class Cat extends Pet {

    private int miceCaught;

    public Cat(String name, double health, int painLevel, int miceCaught) {
        super(name, health, painLevel);
        this.miceCaught = Math.max(miceCaught, 0);
    }

    public Cat(String name, double health, int painLevel) {
        this(name, health, painLevel, 0);
    }

    @Override
    public int treat() {
        int output;
        if (miceCaught < 4) {
            output = (int) ((getPainLevel() * 2) / getHealth());
        } else if (miceCaught <= 7) {
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
            str.append("meow ");
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
        Cat dog = (Cat) o;
        return miceCaught == dog.miceCaught && super.equals(o);
    }

    public int getMiceCaught() {
        return miceCaught;
    }

    public void setMiceCaught(int miceCaught) {
        this.miceCaught = miceCaught;
    }
}
