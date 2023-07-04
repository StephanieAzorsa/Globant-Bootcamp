package guide08.exercises.exercise13.services;

import guide08.exercises.exercise13.entities.Student;

import java.util.Arrays;
import java.util.Scanner;

//CRUD: Create, Read, Update, Delete
public class StudentService {

    Scanner scanner = new Scanner(System.in);

    public Student createStudent(){
        Student students = new Student();
        String[] studentName = new String[5];
        for (int i = 0; i < studentName.length; i++) {
            System.out.print("Enter the student name: ");
            studentName[i] = scanner.nextLine();
        }
        students.setStudentName(studentName);

        return students;
    }

    public void readStudent(Student students){
        System.out.println("Students names: " + Arrays.toString(students.getStudentName()));
    }

    public void updateStudent(Student students){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the student you wish to update: ");
        String studentName = scanner.nextLine();
        for (int i = 0; i < students.getStudentName().length; i++) {
            if (studentName.equals(students.getStudentName()[i])){
                System.out.print("Enter the new student name: ");
                String newStudentName = scanner.nextLine();
                students.getStudentName()[i] = newStudentName;
                System.out.println("Student updated!");
                break;
            }
        }
    }

    public void deleteStudent(Student students){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the student name: ");
        String studentName = scanner.nextLine();
        for (int i = 0; i < students.getStudentName().length; i++) {
            if (studentName.equals(students.getStudentName()[i])){
                students.getStudentName()[i] = null;
                System.out.println("Student deleted!");
                break;
            }
        }
    }

    public void searchStudent(Student students){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the student name: ");
        String studentName = scanner.nextLine();
        for (int i = 0; i < students.getStudentName().length; i++) {
            if (studentName.equals(students.getStudentName()[i])){
                System.out.println("Student found!");
                break;
            }
        }
    }

    public void menuOfTheStudents(Student students){
        boolean exit = false;
        while (!exit){
            System.out.println("\nSTUDENT MENU");
            System.out.println("1. Read student");
            System.out.println("2. Update student");
            System.out.println("3. Delete student");
            System.out.println("4. Search student");
            System.out.println("5. Exit...");
            System.out.print("Enter an option: ");
            int option = scanner.nextInt();
            switch (option) {
                case 1 -> readStudent(students);
                case 2 -> updateStudent(students);
                case 3 -> deleteStudent(students);
                case 4 -> searchStudent(students);
                case 5 -> exit = true;
                default -> System.out.println("Error: Invalid option.");
            }
        }
    }
}
