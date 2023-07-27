package guide08.activities.group_challenge.entities;

import lombok.Data;

@Data
public class Routine {
    private String id;
    private String name;
    private String difficultyLevel;
    private String description;
    private int duration;
}
