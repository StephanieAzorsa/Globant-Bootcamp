package guide08.activities.group_challenge.services;

import guide08.activities.group_challenge.entities.Customer;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerService {
    private static final ArrayList<Customer> customers = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void createCustomer() {
        System.out.println("\nREGISTRATION");
        Customer customer = new Customer();
        System.out.print("Enter the ID of the customer: ");
        customer.setId(scanner.nextLine());
        System.out.print("Enter the name of the customer: ");
        customer.setName(scanner.nextLine());
        System.out.print("Enter the objective of the customer: ");
        customer.setObjective(scanner.nextLine());
        System.out.print("Enter the age of the customer: ");
        customer.setAge(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Enter the height of the customer (m): ");
        customer.setHeight(scanner.nextDouble());
        scanner.nextLine();
        System.out.print("Enter the weight of the customer (kg): ");
        customer.setWeight(scanner.nextDouble());
        scanner.nextLine();
        customers.add(customer);
    }

    public static ArrayList<Customer> getCustomers() {
        return customers;
    }

    public static void readCustomers() {
        if (customers.isEmpty()) {
            System.out.println("There are no customers to show!");
            return;
        }
        getCustomers().forEach(System.out::println);
    }

    public static void updateCustomer(int id, String name, int age, double height, double weight, String objective) {
        System.out.println("\nUPDATE CUSTOMER");
        boolean customerExists = false;
        for (Customer customer : customers) {
            if (customer.getId().equalsIgnoreCase(Integer.toString(id))) {
                customer.setName(name);
                customer.setAge(age);
                customer.setHeight(height);
                customer.setWeight(weight);
                customer.setObjective(objective);
                customerExists = true;
                System.out.println("Customer updated successfully!");
                break;
            }
        }
        if (!customerExists)
            System.out.println("There are no customers with the ID: " + id);
    }

    public static void deleteCustomer(int id) {
        System.out.println("\nDELETE CUSTOMER");
        boolean check = false;
        for (Customer customer : customers) {
            if (customer.getId().equalsIgnoreCase(String.valueOf(id))) {
                customers.remove(customer);
                check = true;
                break;
            }
        }
        if (!check)
            System.out.println("There are no customers with the ID: " + id);
        else
            System.out.println("Customer deleted successfully!");
    }

    public static boolean customerExists(int id) {
        for (Customer customer : customers)
            if (customer.getId().equalsIgnoreCase(String.valueOf(id)))
                return true;
        return false;
    }
}