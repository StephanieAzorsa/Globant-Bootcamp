package guide08.activities.activity2_Exercise1.entities;

import lombok.Data;

@Data
public class Film {
    private String title;
    private String genre;
    private String year;
    private int duration;
    private boolean available = true;
}
