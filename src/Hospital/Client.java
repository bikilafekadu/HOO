/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hospital;

/**
 *
 * @author Abi
 */
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;
public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost");
            HealthMonitor healthMonitor = (HealthMonitor) registry.lookup("HealthMonitor");
            Scanner scanner = new Scanner(System.in);
            int choice;
            do {
                System.out.println("1. Add new patient");
                System.out.println("2. Update patient status");
                System.out.println("3. Delete patient");
                System.out.println("4. View all patients");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // consume the newline character
                switch (choice) {
                    case 1:
                        System.out.print("Enter patient name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter patient age: ");
                        int age = scanner.nextInt();
                        scanner.nextLine(); // consume the newline character
                        System.out.print("Enter date of admission (DD): ");
                        String date = scanner.nextLine();
                        System.out.print("Enter month of admission (MM): ");
                        String month = scanner.nextLine();
                        System.out.print("Enter year of admission (YYYY): ");
                        String year = scanner.nextLine();
                        System.out.print("Enter doctor name: ");
                        String doctorName = scanner.nextLine();
                        System.out.print("Enter patient case: ");
                        String patientCase = scanner.nextLine();
                        System.out.print("Enter duration in hospital (in days): ");
                        int duration = scanner.nextInt();
                        scanner.nextLine(); // consume the newline character
                        Patient patient = new Patient(name, age, date, month, year, doctorName, patientCase, duration);
                        healthMonitor.addNewPatient(patient);
                        System.out.println("Patient added successfully.");
                        break;
                    case 2:
                        System.out.print("Enter patient name: ");
                        String nameToUpdate = scanner.nextLine();
                        System.out.print("Enter new status: ");
                        String status = scanner.nextLine();
                        healthMonitor.updatePatientStatus(nameToUpdate, status);
                        System.out.println("Patient status updated successfully.");
                        break;
                    case 3:
                        System.out.print("Enter patient name: ");
                        String nameToDelete = scanner.nextLine();
                        healthMonitor.deletePatient(nameToDelete);
                        System.out.println("Patient deleted successfully.");
                        break;
                    case 4:
                        List<Patient> patients = healthMonitor.getAllPatients();
                        if (patients.isEmpty()) {
                            System.out.println("No patients found.");
                        } else {
                            for (Patient p : patients) {
                                System.out.println(p);
                            }
                        }
                        break;
                }
            } while (choice != 5);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
