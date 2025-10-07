package labone;
import java.util.*;
public class Person {

    private String name;
    private String email;

    // Constructor
    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // toString method
    public String toString() {
        return "Name: " + name + ", Email: " + email;
    }

}
