package com.bdg.repositories;

import com.bdg.models.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();
    void save(User user);
    boolean isExists(String name, String password);
}
