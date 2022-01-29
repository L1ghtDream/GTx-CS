package dev.lightdream.gtxcs;

public class Fly {

    private double mass;
    private double speed;

    public Fly(double mass, double speed) {
        this.mass = mass;
        this.speed = speed;
    }

    public Fly(double mass) {
        this(mass, 10);
    }

    public Fly() {
        this(5);
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double getSpeed() {
        return speed;
    }

    @SuppressWarnings("unused")
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        if (isDead()) {
            return String.format("I’m dead, but I used to be a fly with a speed of %.2f.", speed);
        }
        return String.format("I’m a speedy fly with %.2f speed and %.2f mass.", speed, mass);

    }

    public void grow(int grow) {
        for (int i = 0; i < grow; i++) {
            this.mass++;
            if (this.mass <= 20) {
                this.speed++;
            } else {
                this.speed -= 0.5;
            }
        }
    }

    public boolean isDead() {
        return mass == 0;
    }
}
