package patterns.basepatterns.creational.singleton;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FakeStorage {
    private static final FakeStorage storage;

    static {
        storage = new FakeStorage();
    }

    private List<User> users;

    private FakeStorage() {
        this.users = new ArrayList<>();
        User user = new User("Marcel", "qwerty007", LocalDate.parse("1990-02-03"));
        User user1 = new User("Sharl", "qwerty007", LocalDate.parse("1994-02-02"));
        User user2 = new User("Carl", "qwerty007", LocalDate.parse("1993-02-01"));

        users.add(user);
        users.add(user1);
        users.add(user2);
    }

    public static FakeStorage storage() {
        return storage;
    }

    public List<User> users() {
        return users;
    }
}