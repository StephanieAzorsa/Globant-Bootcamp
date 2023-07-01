package guide08.examples.example02.services;

import guide08.examples.example02.entities.Salesperson;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class SalespersonService {
    public Salesperson createSalesperson() {
        // Instantiate a salesperson object
        Salesperson sp1 = new Salesperson();

        // Fill in the attributes of the salesperson object
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of the salesperson: ");
        sp1.setName(scanner.next());
        System.out.print("Enter the DNI of the salesperson: ");
        sp1.setDni(scanner.nextInt());
        System.out.print("Enter the base salary of the salesperson: ");
        sp1.setBaseSalary(scanner.nextDouble());
        System.out.print("Enter the day the salesperson started working: ");
        int day = scanner.nextInt();
        System.out.print("Enter the month the salesperson started working: ");
        int month = scanner.nextInt();
        System.out.print("Enter the year the salesperson started working: ");
        int year = scanner.nextInt();
        sp1.setStartDate(new Date(year - 1900, month - 1, day));

        return sp1;
    }

    public void MonthlySales(Salesperson sp1) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the total sales of the salesperson: ");
        double sales = scanner.nextDouble();
        sp1.setCommission(sales * 0.15);
        sp1.setMonthlySales(sp1.getBaseSalary() + sp1.getCommission());
        System.out.println("The monthly salary of " + sp1.getName()
                + " is: " + sp1.getMonthlySales());
    }

    public void Vacations(Salesperson sp1) {
        LocalDate today = LocalDate.now();
        int seniority = today.getYear() - sp1.getStartDate().getYear() - 1900;

        System.out.println("Present year: " + today.getYear());
        System.out.println("Start year: " + sp1.getStartDate());
        System.out.println("Seniority: " + seniority);

        if (seniority < 5) {
            System.out.println("The salesperson " + sp1.getName() + " has 14 days of vacation");
        } else if (seniority < 10) {
            System.out.println("The salesperson " + sp1.getName() + " has 21 days of vacation");
        } else if (seniority < 20) {
            System.out.println("The salesperson " + sp1.getName() + " has 28 days of vacation");
        } else if (seniority > 20) {
            System.out.println("The salesperson " + sp1.getName() + " has 35 days of vacation");
        } else {
            System.out.println("The salesperson " + sp1.getName() + " has 0 days of vacation");
        }
    }
}
