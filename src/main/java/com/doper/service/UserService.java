package com.doper.service;

import com.doper.pojo.User;

import java.util.List;

public interface UserService {
    int addUser(User user);

    User getUserById(int id);

    User getUserByName(String name);

    List<User> getAllUser();
}
