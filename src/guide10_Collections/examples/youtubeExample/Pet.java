package guide10_Collections.examples.youtubeExample;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
    private String name;
    private String nickname;
    private String type;
    private Integer age;

    public Pet(String name, String nickname, String type) {
        this.name = name;
        this.nickname = nickname;
        this.type = type;
    }
}

