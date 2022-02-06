package dev.lightdream.gtxcs;

public abstract class Pet {

    private String name;
    private double health;
    private int painLevel;

    public Pet(String name, double health, int painLevel) {
        this.name = name;
        this.health = Math.max(Math.min(health, 1.0), 0.0);
        this.painLevel = Math.max(Math.min(painLevel, 10), 1);
    }

    public abstract int treat();

    public void speak() {
        String str = "Hello! My name is " + name;
        System.out.println(painLevel <= 5 ? str : str.toUpperCase());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return name.equals(pet.name);
    }

    protected void heal() {
        this.health = 1.0;
        this.painLevel = 1;
    }

    public String getName() {
        return name;
    }

    public double getHealth() {
        return health;
    }

    public int getPainLevel() {
        return painLevel;
    }
}
