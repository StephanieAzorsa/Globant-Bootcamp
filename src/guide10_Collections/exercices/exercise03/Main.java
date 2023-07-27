package guide10_Collections.exercices.exercise03;

import guide10_Collections.exercices.exercise03.services.AdminStudentService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        AdminStudentService studentService = new AdminStudentService();

        boolean exit = false;
        do {
            studentService.createStudent();
            System.out.print("Do you want to add another student? (Y/N) ");
            String option = scanner.next().toUpperCase();
            if (option.equalsIgnoreCase("N")) {
                exit = true;
            }
        } while (!exit);

        System.out.println("\nThe list of students is: ");
        System.out.println(studentService.getStudents());

        System.out.print("Enter the name of the student to calculate the final grade: ");
        String name = scanner.next();
        double finalGrade = studentService.finalGradeForOneStudent(name);
        System.out.println("The final grade of " + name + " is: " + finalGrade);
    }
}
