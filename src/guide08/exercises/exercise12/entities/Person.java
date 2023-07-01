package guide08.exercises.exercise12.entities;

import java.util.Date;
import lombok.Data;

@Data
public class Person {
    private String name;
    private Date birthDate;
}
