package guide08.activities.group_challenge;

import guide08.activities.group_challenge.services.CustomerService;
import guide08.activities.group_challenge.services.RoutineService;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.print("1 for Customers and 2 for Routines (or any other key to exit): ");
            int option = scanner.nextInt();

            if (option == 1) menuOfCustomers();
            else if (option == 2) menuOfRoutines();
            else {
                System.out.println("Exiting...");
                break;
            }
        }
        scanner.close();
    }

    public static void menuOfCustomers() {
        int option;
        do {
            System.out.println("\nCUSTOMERS MENU");
            System.out.println("1. Create customer");
            System.out.println("2. Read customers");
            System.out.println("3. Update customer");
            System.out.println("4. Delete customer");
            System.out.println("5. Exit");
            System.out.print("\nEnter an option: ");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1 -> CustomerService.createCustomer();
                case 2 -> CustomerService.readCustomers();
                case 3 -> {
                    System.out.print("Enter the id of the customer to update: ");
                    int idToUpdate = scanner.nextInt();
                    scanner.nextLine();
                    if (CustomerService.customerExists(idToUpdate)) {
                        System.out.print("Enter the name of the customer: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter the age of the customer: ");
                        int age = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter the height of the customer (m): ");
                        double height = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Enter the weight of the customer (kg): ");
                        double weight = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Enter the objective of the customer: ");
                        String objective = scanner.nextLine();
                        CustomerService.updateCustomer(idToUpdate, name, age, height, weight, objective);
                    } else {
                        System.out.println("There are no customers with the ID: " + idToUpdate);
                    }
                }
                case 4 -> {
                    System.out.print("Enter the id of the customer to delete: ");
                    int idOfDelete = scanner.nextInt();
                    scanner.nextLine();
                    CustomerService.deleteCustomer(idOfDelete);
                }
                case 5 -> System.out.println("See you soon!");
                default -> System.out.println("Incorrect option");
            }
        } while (option != 5);
    }

    public static void menuOfRoutines() {
        int option;
        do {
            Scanner leer = new Scanner(System.in);
            System.out.println("\nROUTINES MENU");
            System.out.println("1. Create routine");
            System.out.println("2. List routines");
            System.out.println("3. Update routine");
            System.out.println("4. Delete routine");
            System.out.println("5. Exit");
            System.out.print("\nEnter an option: ");
            option = leer.nextInt();
            leer.nextLine();
            switch (option) {
                case 1 -> RoutineService.createRoutine();
                case 2 -> System.out.println(RoutineService.getRoutines());
                case 3 -> {
                    System.out.println("Enter the id of the routine to update");
                    int idToUpdate = leer.nextInt();
                    leer.nextLine();
                    System.out.println("Enter the new name of the routine: ");
                    String name = leer.nextLine();
                    System.out.print("Enter the new duration of the routine: ");
                    int duration = leer.nextInt();
                    leer.nextLine();
                    System.out.print("Enter the new difficulty level of the routine: ");
                    String difficultyLevel = leer.nextLine();
                    System.out.print("Enter the new description of the routine: ");
                    String description = leer.nextLine();
                    RoutineService.updateRoutine(idToUpdate, name, duration, difficultyLevel, description);
                }
                case 4 -> {
                    System.out.print("Enter the id of the routine to delete: ");
                    int idToDelete = leer.nextInt();
                    leer.nextLine();
                    RoutineService.deleteRoutine(idToDelete);
                }
                case 5 -> System.out.println("See you soon!");
                default -> System.out.println("Incorrect option");
            }
        } while (option != 5);
    }
}
