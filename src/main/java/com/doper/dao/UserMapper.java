package com.doper.dao;

import com.doper.pojo.User;

import java.util.List;

public interface UserMapper {
    int addUser(User user);

    User getUserById(int id);

    User getUserByName(String name);

    List<User> getAllUser();
}
