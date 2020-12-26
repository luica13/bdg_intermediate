package com.bdg.repositories;

import com.bdg.fake.FakeStorage;
import com.bdg.models.User;

import java.util.List;

public class UserRepositoryInMemoryImpl implements UserRepository {

    private List<User> users;

    @Override
    public List<User> findAll() {
        return FakeStorage.storage().users();
    }

    @Override
    public void save(User user) {
        FakeStorage.storage().users().add(user);
    }

    @Override
    public boolean isExists(String name, String password) {
        for (User user : FakeStorage.storage().users()) {
            if (user.getName().equals(name) &&
                    user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
