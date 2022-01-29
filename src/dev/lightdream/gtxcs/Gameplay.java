package dev.lightdream.gtxcs;

public class Gameplay {

    public static void main(String[] args) {
        BlueAstronaut Bob = new BlueAstronaut("Bob", 20, 8, 30);
        BlueAstronaut Heath = new BlueAstronaut("Heath", 30, 3, 21);
        BlueAstronaut Albert = new BlueAstronaut("Albert", 44, 2, 0);
        BlueAstronaut Angel = new BlueAstronaut("Angel", 0, 1, 0);

        RedAstronaut Liam = new RedAstronaut("Liam", 19, "experienced");
        RedAstronaut SuspiciousPerson = new RedAstronaut("Suspicious Person", 100, "expert");

        Liam.sabotage(Bob);
        Liam.freeze(SuspiciousPerson);
        Liam.freeze(Albert);
        Albert.emergencyMeeting();
        SuspiciousPerson.emergencyMeeting();
        Bob.emergencyMeeting();
        Heath.completeTask();
        Heath.completeTask();
        Heath.completeTask();
        Liam.freeze(Angel);
        Liam.sabotage(Bob);
        Liam.sabotage(Bob);
        Liam.freeze(Bob);
        Angel.emergencyMeeting();
    }
}