package guide08.exercises.exercise01.entities;

import lombok.Data;

@Data
public class Book {
    private String isbn;
    private String title;
    private String author;
    private int numberOfPages;
}
