package guide08.exercises.exercise13;

import guide08.exercises.exercise13.entities.Course;
import guide08.exercises.exercise13.services.CourseService;
import guide08.exercises.exercise13.services.StudentService;

public class Main {
    public static void main(String[] args) {
        CourseService cs = new CourseService();
        StudentService ss = new StudentService();

        Course course = cs.createCourse();

        cs.printCourse(course);

        ss.menuOfTheStudents(course.getStudents());
    }
}
