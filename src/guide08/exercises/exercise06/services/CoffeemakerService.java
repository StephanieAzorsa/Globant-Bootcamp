package guide08.exercises.exercise06.services;

import guide08.exercises.exercise06.entities.Coffeemaker;

import java.util.Scanner;

public class CoffeemakerService {
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Makes the current amount equal to the maximum capacity.
     */
    public void fillCoffeemaker() {
        Coffeemaker cm = new Coffeemaker();
        cm.setCurrentCoffee(cm.getMaximumCoffee());
        System.out.println("The coffeemaker has been filled");
    }

    /**
     * The size of an empty cup is requested, the method receives
     *
     * @param cupSize cupSize the size of the cup to be filled
     * @param cm      cm the Coffee maker object representing the coffee machine
     */
    public void serveCup(int cupSize, Coffeemaker cm) {
        if (cm.getCurrentCoffee() < cupSize) {
            System.out.println("The cup has been filled");
            System.out.println("The remaining amount is: " + (cupSize - cm.getCurrentCoffee()));
        } else
            System.out.println("The cup has been filled");
    }

    /**
     * Sets the current amount of coffee to zero.
     *
     * @param cm cm the Coffee maker object representing the coffee machine
     */
    public void emptyCoffeeCup(Coffeemaker cm) {
        cm.setCurrentCoffee(0);
        System.out.println("The cup has been emptied");
    }

    /**
     * The user is asked for a quantity of coffee, the method receives
     *
     * @param quantity quantity the amount of coffee to be added
     * @param cm       cm the Coffee maker object representing the coffee machine
     */
    public void addCafe(int quantity, Coffeemaker cm) {
        cm.setCurrentCoffee(cm.getCurrentCoffee() + quantity);
        System.out.println("The coffee has been added");
    }

    /**
     * Creates a switch statement to call the methods of the CoffeemakerService classes.
     *
     * @param cm cm the Coffee maker object representing the coffee machine
     */
    public void showMenu(Coffeemaker cm) {
        int choice;
        do {
            menu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> fillCoffeemaker();
                case 2 -> {
                    int cupSize;
                    System.out.print("Enter the size of the cup: ");
                    cupSize = scanner.nextInt();
                    serveCup(cupSize, cm);
                }
                case 3 -> emptyCoffeeCup(cm);
                case 4 -> {
                    int quantity;
                    System.out.print("Enter the quantity of coffee: ");
                    quantity = scanner.nextInt();
                    addCafe(quantity, cm);
                }
                case 5 -> System.out.println("Exit...");
                default -> System.out.println("Invalid choice");
            }
        } while (choice != 5);
    }

    /**
     * Creates a menu with the following options
     */
    public void menu() {
        System.out.println("====================================");
        System.out.println("COFFEEMAKER MENU");
        System.out.println("1. Fill the coffeemaker.");
        System.out.println("2. Serve a cup.");
        System.out.println("3. Empty the cup.");
        System.out.println("4. Add coffee.");
        System.out.println("5. Exit.");
        System.out.println("====================================");
        System.out.print("Enter an option: ");
    }
}

