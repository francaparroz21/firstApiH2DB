package com.example.demo.Services;

import com.example.demo.model.User;

import java.util.List;

public interface UserServiceIn {
    User saveUser(User u);

    List<User> getUsers();

    User getUser(Long id);

    User userModify(Long id,User u);

    User passModify(Long id,String pass);

    boolean deleteUser(Long id);
}
