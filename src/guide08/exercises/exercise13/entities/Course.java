package guide08.exercises.exercise13.entities;

import lombok.Data;

@Data
public class Course {
    private String courseName;
    private String shift;
    private CourseOperations operation;
    private Student students;

    public void setShift(String shift) {
        if (shift.equals("morning") || shift.equals("afternoon"))
            this.shift = shift;
        else
            System.out.println("Error: Invalid shift.");
    }

}
