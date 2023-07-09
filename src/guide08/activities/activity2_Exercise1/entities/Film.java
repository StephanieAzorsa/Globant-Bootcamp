package guide08.activities.activity2_Exercise1.entities;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Film {
    private String title;
    private String genre;
    private LocalDate year;
    private int duration;
    private boolean available = true;
}
