package dev.lightdream.gtxcs;

import java.util.Arrays;

public class RedAstronaut extends Player implements Impostor {

    private String skill;

    /**
     * Constructor for Player Objects. Be sure to use this constructor, as it properly populates the players array.
     * The logic in this constructor ensures that players is always full, although frozen players will still be in it.
     * NOTE: Use getPlayers() each time you need it, since the reference will change with every new instance.
     *
     * @param name     Name of the player
     * @param susLevel Integer that represents the suspicion level, with higher being more suspicious.
     */
    public RedAstronaut(String name, int susLevel, String skill) {
        super(name, susLevel);
        this.skill = skill;
    }

    public RedAstronaut(String name) {
        this(name, 15, "experienced");
    }

    @Override
    public void freeze(Player p) {
        if (p instanceof Impostor) {
            return;
        }
        if (this.isFrozen() || p.isFrozen() || this.getSusLevel() > p.getSusLevel()) {
            this.setSusLevel(getSusLevel() * 2);
            return;
        }

        p.setFrozen(true);

        gameOver();
    }

    @Override
    public void sabotage(Player p) {
        if (p instanceof Impostor || p.isFrozen()) {
            return;
        }

        if (this.getSusLevel() < 20) {
            p.setSusLevel(p.getSusLevel() * 150 / 100);
        } else {
            p.setSusLevel(p.getSusLevel() * 125 / 100);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof RedAstronaut)) {
            return false;
        }
        RedAstronaut that = (RedAstronaut) o;
        return that.getName()
                .equals(this.getName()) && that.isFrozen() == this.isFrozen() && that.getSusLevel() == this.getSusLevel() && that.getSkill()
                .equals(this.getSkill());
    }

    @Override
    public String toString() {
        String s = super.toString();
        s += String.format(" I am an %s player!", getSkill());
        if (getSusLevel() > 15) {
            s = s.toUpperCase();
        }
        return s;
    }

    @Override
    public void emergencyMeeting() {
        if (isFrozen()) {
            return;
        }

        Arrays.sort(getPlayers());
        Player[] eligible = Arrays.stream(getPlayers())
                .filter(p -> !p.isFrozen() && !p.equals(this))
                .toArray(Player[]::new);

        if (eligible.length == 1) {
            eligible[0].setFrozen(true);
            return;
        }

        if (eligible[eligible.length - 1].getSusLevel() == eligible[eligible.length - 2].getSusLevel()) {
            return;
        } else {
            eligible[eligible.length - 1].setFrozen(true);
        }

        gameOver();
    }

    public String getSkill() {
        return skill;
    }

    @SuppressWarnings("unused")
    public void setSkill(String skill) {
        this.skill = skill;
    }
}
