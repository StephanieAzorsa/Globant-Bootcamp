package guide08.activities.group_challenge.services;

import guide08.activities.group_challenge.entities.Routine;

import java.util.ArrayList;
import java.util.Scanner;

public class RoutineService {
    private static final ArrayList<Routine> routines = new ArrayList<>();
    private static final Scanner leer = new Scanner(System.in);

    public static void createRoutine() {
        System.out.println("\nCREATE ROUTINE");
        Routine routine = new Routine();
        System.out.println("Enter the ID of the routine: ");
        routine.setId(leer.nextLine().trim());
        System.out.print("Enter the name of the routine: ");
        routine.setName(leer.nextLine().trim());
        System.out.print("Enter the difficulty level of the routine: ");
        routine.setDifficultyLevel(leer.nextLine().trim());
        System.out.print("Enter the description of the routine: ");
        routine.setDescription(leer.nextLine().trim());
        System.out.print("Enter the duration of the routine (minutes): ");
        routine.setDuration(leer.nextInt());
        leer.nextLine();
        routines.add(routine);
        System.out.println("Routine created successfully!");
    }

    public static ArrayList<Routine> getRoutines() {
        System.out.println("\nLIST OF ROUTINES");
        return routines;
    }

    public static void updateRoutine(int id, String name, int duration, String levelOfDifficulty, String description) {
        System.out.println("\nUPDATE ROUTINE");
        boolean check = false;
        for (Routine routine : routines) {
            if (routine.getId().equalsIgnoreCase(String.valueOf(id))) {
                routines.get(routines.indexOf(routine)).setName(name);
                routines.get(routines.indexOf(routine)).setDuration(duration);
                routines.get(routines.indexOf(routine)).setDifficultyLevel(levelOfDifficulty);
                routines.get(routines.indexOf(routine)).setDescription(description);
                check = true;
                break;
            }
        }
        if (!check)
            System.out.println("Does not exist routine to update!");
        else
            System.out.println("Routine updated successfully!");
    }

    public static void deleteRoutine(int id) {
        System.out.println("\nDELETE ROUTINE");
        boolean check = false;
        for (Routine routine : routines) {
            if (routine.getId().equalsIgnoreCase(Integer.toString(id))) {
                routines.remove(routine);
                check = true;
                break;
            }
        }
        if (!check)
            System.out.println("Does not exist routine to delete!");
        else
            System.out.println("Routine deleted successfully!");
    }
}