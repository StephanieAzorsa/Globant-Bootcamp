package guide10_Collections.exercices.exercise03.services;

import guide10_Collections.exercices.exercise03.entities.Estudiante;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AdminStudentService {
    private final Scanner scanner;
    private final ArrayList<Estudiante> students;

    public AdminStudentService() {
        this.scanner = new Scanner(System.in).useDelimiter("\n");
        this.students = new ArrayList<>();
    }

    public void createStudent() {
        Estudiante student = new Estudiante();
        System.out.print("Enter the name of the student: ");
        student.setName(scanner.next().trim());
        System.out.print("Enter the last name of the student: ");
        student.setLastName(scanner.next().trim());
        System.out.print("Enter the dni of the student: ");
        student.setDni(scanner.nextInt());
        System.out.print("Enter the age of the student: ");
        student.setAge(scanner.nextInt());

        student.setGrades(enterGrades());

        students.add(student);
    }

    public ArrayList<Estudiante> getStudents() {
        return students;
    }

    private List<Integer> enterGrades() {
        List<Integer> grades = new ArrayList<>();
        int numbersOfGrades = 3;
        for (int i = 1; i <= numbersOfGrades; i++) {
            int grade = askAndValidateGrade(i);
            grades.add(grade);
        }
        return grades;
    }

    private int askAndValidateGrade(int number) {
        while (true) {
            try {
                System.out.print("Enter grade " + number + ": ");
                int grade = scanner.nextInt();

                if (grade < 0 || grade > 20)
                    System.out.println("Invalid input. Grades must be between 0 and 20.");
                else
                    return grade;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer grade.");
                scanner.nextLine();
            }
        }
    }

    public double finalGradeForOneStudent(String name) {
        Estudiante student = getStudentByName(name);
        if (student != null)
            return calculateFinalGrade(student.getGrades());
        else
            throw new IllegalArgumentException("The student " + name + " was not found.");
    }

    private Estudiante getStudentByName(String name) {
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("The name cannot be null or empty");

        String nameLowerCase = name.toLowerCase().trim();

        return students.stream()
                .filter(estudiante -> estudiante.getName().equalsIgnoreCase(nameLowerCase))
                .findFirst()
                .orElse(null);
    }

    public double calculateFinalGrade(List<Integer> grades) {
        if (grades == null || grades.isEmpty())
            throw new IllegalArgumentException("The list of grades cannot be null or empty.");

        int sum = grades.stream().mapToInt(Integer::intValue).sum();
        return (double) sum / grades.size();
    }
}
