package dev.lightdream.gtxcs;

import java.util.Arrays;

public class BlueAstronaut extends Player implements Crewmate {

    private int numTasks;
    private int taskSpeed;

    /**
     * Constructor for Player Objects. Be sure to use this constructor, as it properly populates the players array.
     * The logic in this constructor ensures that players is always full, although frozen players will still be in it.
     * NOTE: Use getPlayers() each time you need it, since the reference will change with every new instance.
     *
     * @param name     Name of the player
     * @param susLevel Integer that represents the suspicion level, with higher being more suspicious.
     */
    public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed) {
        super(name, susLevel);
        this.numTasks = numTasks;
        this.taskSpeed = taskSpeed;
    }

    public BlueAstronaut(String name) {
        this(name, 15, 6, 10);
    }

    public int getNumTasks() {
        return numTasks;
    }

    @SuppressWarnings("unused")
    public void setNumTasks(int numTasks) {
        this.numTasks = numTasks;
    }

    public int getTaskSpeed() {
        return taskSpeed;
    }

    @SuppressWarnings("unused")
    public void setTaskSpeed(int taskSpeed) {
        this.taskSpeed = taskSpeed;
    }

    @Override
    public void completeTask() {
        if (isFrozen()) {
            return;
        }

        if (taskSpeed > 20) {
            numTasks -= 2;
        } else {
            numTasks--;
        }

        if (numTasks < 0) {
            numTasks = 0;
        }

        if (numTasks == 0) {
            System.out.println("I have completed all my tasks");
        }

        setSusLevel(getSusLevel() / 2);
    }

    @Override
    public void emergencyMeeting() {
        if (isFrozen()) {
            return;
        }

        Arrays.sort(getPlayers());
        Player[] eligible = Arrays.stream(getPlayers())
                .filter(p -> !p.isFrozen())
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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BlueAstronaut)) {
            return false;
        }
        BlueAstronaut that = (BlueAstronaut) o;
        return that.getName()
                .equals(this.getName()) && that.isFrozen() == this.isFrozen() && that.getSusLevel() == this.getSusLevel() && that.getNumTasks() == this.getNumTasks() && that.getTaskSpeed() == this.getTaskSpeed();
    }

    @Override
    public String toString() {
        String s = super.toString();
        s += String.format(" I have %d left over.", getNumTasks());
        if (getSusLevel() > 15) {
            s = s.toUpperCase();
        }
        return s;
    }
}
