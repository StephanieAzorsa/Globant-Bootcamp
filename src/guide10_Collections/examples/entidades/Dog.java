package guide10_Collections.examples.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dog {
    private String name;
    private Integer age;

    public static Comparator<Dog> ageComparator = Comparator.comparing(Dog::getAge);
}
