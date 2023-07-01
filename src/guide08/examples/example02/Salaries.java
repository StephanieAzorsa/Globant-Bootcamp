package guide08.examples.example02;

import guide08.examples.example02.entities.Salesperson;
import guide08.examples.example02.services.SalespersonService;

public class Salaries {
    public static void main(String[] args) {
        SalespersonService ssp = new SalespersonService();
        Salesperson sp1 = ssp.createSalesperson();
        ssp.MonthlySales(sp1);
        ssp.Vacations(sp1);

    }

}
