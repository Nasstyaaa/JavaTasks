package com.example.demo.Service;

import com.example.demo.Data.User;

import java.util.List;

public interface UserService {
        List<User> getUsers();
        User saveUser(User user);
        List<User> findAllByOrderByFirstNameAsc();
        List<User> findAllByOrderByLastNameAsc();
        List<User> findAllByOrderByIdAsc();
}
