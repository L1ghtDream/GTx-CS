package dev.lightdream.gtxcs;

import java.io.*;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Clinic {

    private File patientFile;
    private int day;

    public Clinic(File file) {
        this.patientFile = file;
        this.day = 1;
    }

    public Clinic(String fileName) throws FileNotFoundException {
        URL url = Clinic.class.getResource(fileName);
        if (url == null) {
            throw new FileNotFoundException();
        }
        this.patientFile = new File(url.getFile());
        this.day = 1;
    }

    @SuppressWarnings({"ConstantConditions", "StringConcatenationInLoop"})
    public String nextDay(File f) throws FileNotFoundException, InvalidPetException {
        System.out.println(f);
        Scanner scanner = new Scanner(f);
        String str;
        String output = "";
        while ((str = scanner.nextLine()) != null) {

            String[] data = str.split(",");
            String name = data[0];
            String type = data[1];
            double specific = Double.parseDouble(data[2]);
            int entry = Integer.parseInt(data[3]);

            if (!type.equalsIgnoreCase("Dog") && !type.equalsIgnoreCase("Cat")) {
                throw new InvalidPetException();
            }

            System.out.println("Consultation for [name] the [typeOfPet] at [time].\nWhat is the health of [name]?".replace("[name]", name)
                    .replace("[typeOfPet]", type)
                    .replace("[time]", String.valueOf(entry)));

            Scanner user = new Scanner(System.in);
            double health;
            try {
                health = user.nextDouble();
            } catch (Exception e) {
                health = user.nextDouble();
            }

            System.out.println("On a scale of 1 to 10, how much pain is [name] in right now?".replace("[name]", name));
            int pain;
            try {
                pain = user.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number");
                user.next();
                pain = user.nextInt();
            }

            Pet pet = null;

            if (type.equalsIgnoreCase("Cat")) {
                pet = new Cat(name, health, pain, (int) specific);
            }
            if (type.equalsIgnoreCase("Dog")) {
                pet = new Dog(name, health, pain, specific);
            }

            pet.speak();

            String s = "[Name],[Species],[DroolRate/MiceCaught],[Day],[EntryTime],[ExitTime],[InitialHealth],[InitialPainLevel]";
            s = s.replace("[Name]", name);
            s = s.replace("[Species]", type);
            s = s.replace("[DroolRate/MiceCaught]", String.valueOf(specific));
            s = s.replace("[Day]", String.valueOf(day));
            s = s.replace("[EntryTime]", String.valueOf(entry));
            s = s.replace("[ExitTime]", addTime(String.valueOf(entry), pet.treat()));
            s = s.replace("[InitialHealth]", String.valueOf(health));
            s = s.replace("[InitialPainLevel]", String.valueOf(pain));
            output += s + "\n";
        }
        return output;
    }

    public String nextDay(String fileName) throws FileNotFoundException, InvalidPetException {
        URL url = getClass().getResource(fileName);
        if (url == null) {
            throw new FileNotFoundException();
        }
        return nextDay(new File(url.getFile()));
    }

    public boolean addToFile(String patientInfo) {
        try {
            PrintWriter printWriter = new PrintWriter(new FileOutputStream(patientFile.getName(), true));
            printWriter.println(patientInfo);
            printWriter.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    private String addTime(String timeIn, int treatmentTime) {
        int hours = 0;
        while (treatmentTime >= 60) {
            hours++;
            treatmentTime -= 60;
        }
        treatmentTime += hours * 100;
        int time = Integer.parseInt(timeIn);
        return String.valueOf(treatmentTime + time);
    }

}
