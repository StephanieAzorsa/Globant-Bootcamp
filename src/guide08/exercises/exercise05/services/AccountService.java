package guide08.exercises.exercise05.services;

import guide08.exercises.exercise05.entities.Account;

import java.util.Scanner;

public class AccountService {
    private final Scanner scanner = new Scanner(System.in);

    /**
     * This method requests the account number and DNI to the user.
     *
     * @return Account object.
     */
    public Account requestAccountData() {
        Account acc = new Account();

        System.out.println("WELCOME!");
        System.out.print("Enter account number: ");
        acc.setAccountNumber(scanner.nextInt());
        System.out.print("Enter DNI: ");
        acc.setDni(scanner.nextLong());

        return acc;
    }

    /**
     * This method adds a deposit to the account.
     *
     * @param acc    Account object.
     * @param amount Amount to deposit.
     */
    public void deposit(Account acc, double amount) {
        acc.setCurrentBalance(acc.getCurrentBalance() + amount);
    }

    /**
     * This method withdraws money from the account.
     *
     * @param acc    Account object.
     * @param amount Amount to withdraw.
     */
    public void withdraw(Account acc, double amount) {
        if (acc.getCurrentBalance() <= 0) {
            System.out.println("You don't have enough money");
            System.out.println("Your current balance is: " + acc.getCurrentBalance());
        } else if (amount > acc.getCurrentBalance()) {
            System.out.println("You don't have enough money");
            System.out.println("Your current balance is: " + acc.getCurrentBalance());
        } else {
            acc.setCurrentBalance(acc.getCurrentBalance() - amount);
        }
    }

    /**
     * This method withdraws a 20% of the current balance.
     *
     * @param acc Account object.
     */
    public void quickWithdraw(Account acc) {
        boolean isWithdraw;
        if (acc.getCurrentBalance() <= 0) {
            System.out.println("You don't have enough money");
        } else {
            System.out.println("You have access to withdraw a 20% of your current balance");
            System.out.println("You can withdraw: " + acc.getCurrentBalance() * 0.2);
            System.out.println("Do you want to withdraw? (true/false)");
            isWithdraw = scanner.nextBoolean();
            if (isWithdraw)
                acc.setCurrentBalance(acc.getCurrentBalance() - acc.getCurrentBalance() * 0.2);
            System.out.println("Current balance: " + acc.getCurrentBalance());
        }
    }

    /**
     * This method checks the current balance.
     *
     * @param acc Account object.
     */
    public void checkBalance(Account acc) {
        System.out.println("Your current balance is: " + acc.getCurrentBalance());
    }

    /**
     * This method shows the account number, DNI and current balance.
     *
     * @param acc Account object.
     */
    public void consultData(Account acc) {
        System.out.println("Account number: " + acc.getAccountNumber());
        System.out.println("DNI: " + acc.getDni());
        System.out.println("Current balance: " + acc.getCurrentBalance());
    }

    /**
     * This method selects an option from the menu, calls the corresponding method and shows the result.
     *
     * @param acc Account object.
     */
    public void showMenu(Account acc) {
        double amount;
        int choice;
        do {
            menu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> checkBalance(acc);
                case 2 -> consultData(acc);
                case 3 -> {
                    System.out.print("Enter the amount to be deposited: ");
                    amount = scanner.nextDouble();
                    deposit(acc, amount);
                }
                case 4 -> {
                    System.out.print("Enter the amount to be withdrawn: ");
                    amount = scanner.nextDouble();
                    withdraw(acc, amount);
                }
                case 5 -> quickWithdraw(acc);
                case 6 -> System.out.println("Exit...");
                default -> System.out.println("Invalid choice");
            }
        } while (choice != 6);

    }

    /**
     * This method shows the menu.
     */
    public void menu() {
        System.out.println("====================================");
        System.out.println("1. Check balance");
        System.out.println("2. Consult data");
        System.out.println("3. Deposit");
        System.out.println("4. Withdraw");
        System.out.println("5. Quick withdraw");
        System.out.println("6. Exit");
        System.out.println("====================================");
        System.out.print("Enter an option: ");
    }
}