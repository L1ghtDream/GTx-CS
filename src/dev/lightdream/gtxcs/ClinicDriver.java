package dev.lightdream.gtxcs;

import java.io.FileNotFoundException;

public class ClinicDriver {

    public static void main(String[] args) {
        try {
            Clinic clinic = new Clinic("Patients.csv");
            String dayOneReport;
            dayOneReport = clinic.nextDay("Appointments.csv");
            String[] dayOneAppointments = dayOneReport.split("\\n");
            for (String appointment : dayOneAppointments) {
                if (!clinic.addToFile(appointment)) {
                    System.out.println("Appointment could not be added to file!");
                }
            }
        } catch (FileNotFoundException | InvalidPetException exception) {
            exception.printStackTrace();
        }

    }
}
