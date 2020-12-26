package com.bdg.fake;

import com.bdg.models.User;

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
        User user1 = new User("Khachik", "qwerty007", LocalDate.parse("1992-02-02"));
        User user2 = new User("Gexam", "qwerty008", LocalDate.parse("1994-04-14"));
        User user3 = new User("David", "qwerty009", LocalDate.parse("1990-06-20"));

        users.add(user1);
        users.add(user2);
        users.add(user3);
    }

    public static FakeStorage storage() {
        return storage;
    }

    public List<User> users() {
        return this.users;
    }
}
