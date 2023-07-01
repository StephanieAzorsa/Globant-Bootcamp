package guide08.examples.example01.entities;

import java.util.Date;

public class User {
    public String name;
    public String lastname;
    public int dni;
    public Date birthday;
    public String country;

    public User() {
    }

    public User(String name, String lastname, int dni, Date birthday, String country) {
        this.name = name;
        this.lastname = lastname;
        this.dni = dni;
        this.birthday = birthday;
        this.country = country;
    }
}
