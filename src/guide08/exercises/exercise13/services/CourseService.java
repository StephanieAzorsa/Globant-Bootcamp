package guide08.exercises.exercise13.services;

import guide08.exercises.exercise13.entities.Course;
import guide08.exercises.exercise13.entities.CourseOperations;

import java.util.Scanner;

public class CourseService {
    private final Scanner scanner = new Scanner(System.in);
    private final CourseOperations co = new CourseOperations();
    private final StudentService ss = new StudentService();


    public Course createCourse() {
        Course course = new Course();
        System.out.print("Enter the course name: ");
        course.setCourseName(scanner.nextLine());

        validateShift(course);

        System.out.print("Enter the number of hours per day: ");
        co.setNumberOfHoursPerDay(scanner.nextInt());
        System.out.print("Enter the number of days per week: ");
        co.setNumberOfDaysPerWeek(scanner.nextInt());
        System.out.print("Enter the price per hour: ");
        co.setPricePerHour(scanner.nextDouble());

        course.setStudents(ss.createStudent());

        return course;
    }

    public void validateShift(Course course) {
        boolean validShift = false;
        while (!validShift) {
            System.out.print("Enter the course shift (morning or afternoon): ");
            String shiftInput = scanner.nextLine().toLowerCase();
            course.setShift(shiftInput);
            if (course.getShift() != null) {
                validShift = true;
            }
        }
    }

    public double calculateWeeklyProfit(Course course) {
        return co.getNumberOfHoursPerDay()
                * co.getNumberOfDaysPerWeek()
                * co.getPricePerHour()
                * course.getStudents().getStudentName().length;
    }

    public void printCourse(Course course) {
        StudentService ss = new StudentService();
        System.out.println("\nDATA OF THE COURSE");
        System.out.println("Course name: " + course.getCourseName());
        System.out.println("Course shift: " + course.getShift());
        ss.readStudent(course.getStudents()); //Students names
        System.out.println("Weekly profit: " + calculateWeeklyProfit(course));
    }

}
