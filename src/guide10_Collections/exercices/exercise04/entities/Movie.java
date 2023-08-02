package guide10_Collections.exercices.exercise04.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    private String title;
    private String director;
    private LocalDateTime duration;
}
