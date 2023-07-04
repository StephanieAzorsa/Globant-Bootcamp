package guide08.exercises.exercise07;

import guide08.exercises.exercise07.entities.Person;
import guide08.exercises.exercise07.services.PersonService;

public class PersonApp {
    public static void main(String[] args) {
        PersonService ps = new PersonService();

        Person p1 = new Person("Juan", "Perez", 20, "M", 70, 1.80f);
        Person p2 = new Person("Maria", "Gomez", 15, "F", 50, 1.60f);
        Person p3 = new Person("Pedro", "Gonzalez", 30, "O", 90, 1.70f);
        Person p4 = new Person("Jose", "Garcia", 40, "M", 80, 1.75f);

        Person[] people = {p1, p2, p3, p4};

        for (Person p : people) {
//            ps.showPerson(p);
            System.out.println(p.toString());
        }

        int countBelowWeight = 0;
        int countIdealWeight = 0;
        int countAboveWeight = 0;
        int countAdults = 0;
        int countMinors = 0;

        for (Person p : people) {
            int imcResult = ps.calculateIMC(p);
            if (imcResult == -1)
                countBelowWeight++;
            else if (imcResult == 0)
                countIdealWeight++;
            else if (imcResult == 1)
                countAboveWeight++;

            if (ps.isAdult(p))
                countAdults++;
            else
                countMinors++;
        }

        int totalCount = people.length;
        double percentageBelowWeight = (double) countBelowWeight / totalCount * 100;
        double percentageIdealWeight = (double) countIdealWeight / totalCount * 100;
        double percentageAboveWeight = (double) countAboveWeight / totalCount * 100;
        double percentageAdults = (double) countAdults / totalCount * 100;
        double percentageMinors = (double) countMinors / totalCount * 100;

        System.out.println("\nPercentage of people below weight: " + percentageBelowWeight + "%");
        System.out.println("Percentage of people at ideal weight: " + percentageIdealWeight + "%");
        System.out.println("Percentage of people above weight: " + percentageAboveWeight + "%");
        System.out.println("Percentage of adults: " + percentageAdults + "%");
        System.out.println("Percentage of minors: " + percentageMinors + "%");

    }
}
