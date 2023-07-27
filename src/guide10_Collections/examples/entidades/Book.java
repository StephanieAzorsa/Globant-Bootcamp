package guide10_Collections.examples.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    private String title;
    private String author;
    private Integer year;
}
