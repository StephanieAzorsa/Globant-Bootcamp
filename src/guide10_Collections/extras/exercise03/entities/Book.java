package guide10_Collections.extras.exercise03.entities;

import lombok.Data;

@Data
public class Book {
    private String title;
    private String author;
    private Integer numberOfCopies;
    private Integer numberOfCopiesAvailable;
    private Integer numberOfCopiesBorrowed;
    private Boolean isAvailable = true;
}
