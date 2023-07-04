package guide08.exercises.exercise05;

import guide08.exercises.exercise05.entities.Account;
import guide08.exercises.exercise05.services.AccountService;

public class BankAccountApp {
    public static void main(String[] args) {
        AccountService as = new AccountService();
        Account account = as.requestAccountData();
        as.showMenu(account);
    }
}
