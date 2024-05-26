import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Patient {
    private int id;
    private String name;
    private String diagnosis;

    public Patient(int id, String name, String diagnosis) {
        this.id = id;
        this.name = name;
        this.diagnosis = diagnosis;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDiagnosis() {
        return diagnosis;
    }
}

public class HospitalManagementSystem {
    private static List<Patient> patientList = new ArrayList<>();
    private static int nextId = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nHospital Management System");
            System.out.println("1. Add Patient");
            System.out.println("2. Display Patients");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addPatient(scanner);
                    break;
                case 2:
                    displayPatients();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);

        scanner.close();
    }

    private static void addPatient(Scanner scanner) {
        System.out.print("Enter patient name: ");
        String name = scanner.next();
        System.out.print("Enter patient diagnosis: ");
        String diagnosis = scanner.next();

        Patient patient = new Patient(nextId++, name, diagnosis);
        patientList.add(patient);
        System.out.println("Patient added successfully!");
    }

    private static void displayPatients() {
        System.out.println("\nPatient Records:");
        for (Patient patient : patientList) {
            System.out.println("ID: " + patient.getId() + ", Name: " + patient.getName() + ", Diagnosis: " + patient.getDiagnosis());
        }
    }
}
