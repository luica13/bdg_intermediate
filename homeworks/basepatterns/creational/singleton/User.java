package patterns.basepatterns.creational.singleton;

import java.time.LocalDate;

public class User {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    public User(String firstName, String lastName, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User: " + firstName + " " + lastName + " " + birthDate;
    }
}
