package guide10_Collections.examples.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;

@Data
@AllArgsConstructor
public class Student {
    private String name;
    private String lastName;
    private Integer age;
    private Integer dni;

    public static Comparator<Student> dniComparator = new Comparator<Student>() {
        @Override
        public int compare(Student student1, Student student2) {
            return student1.getDni().compareTo(student2.getDni());
        }
    };
}
