package guide08.examples.example01.entities;

public class Pet {
    private String name;
    private String nickname;
    private String type;
    private String color;
    private int age;
    private boolean tail;
    private String breed;
    private int energy;

    public Pet() {
        this.energy = 1000;
    }

    public Pet(String name, String nickname, String type) {
        this.name = name;
        this.nickname = nickname;
        this.type = type;
        this.energy = 1000;
    }

    public Pet(String name, String nickname, String type, String color, int age, boolean tail, String breed) {
        this.name = name;
        this.nickname = nickname;
        this.type = type;
        this.color = color;
        this.age = age;
        this.tail = tail;
        this.breed = breed;
        this.energy = 1000;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() > 0) {
            this.name = name;
        } else {
            System.out.println("The name cannot be empty");
        }
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isTail() {
        return tail;
    }

    public void setTail(boolean tail) {
        this.tail = tail;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    /**
     * Function intended to walk
     *
     * @param energySubtract
     * @return energy
     */
    public int walk(int energySubtract) {
        energy -= energySubtract;
        return energy;
    }

    /**
     * Method overloading
     * Function intended to walk around
     *
     * @param laps
     * @return energy
     */
    public int walk(int energySubtract, int laps) {
        for (int i = 0; i < laps; i++) {
            energy -= energySubtract;
        }
        return energy;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", type='" + type + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                ", tail=" + tail +
                ", breed='" + breed + '\'' +
                ", energy=" + energy +
                '}';
    }
}