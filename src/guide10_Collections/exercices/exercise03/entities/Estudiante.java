package guide10_Collections.exercices.exercise03.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estudiante {
    private String name;
    private String lastName;
    private Integer dni;
    private Integer age;
    private List<Integer> grades;
}
