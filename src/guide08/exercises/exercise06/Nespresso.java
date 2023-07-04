package guide08.exercises.exercise06;

import guide08.exercises.exercise06.entities.Coffeemaker;
import guide08.exercises.exercise06.services.CoffeemakerService;

public class Nespresso {
    public static void main(String[] args) {
        Coffeemaker cm = new Coffeemaker();
        CoffeemakerService cs = new CoffeemakerService();
        cs.showMenu(cm);
    }
}
