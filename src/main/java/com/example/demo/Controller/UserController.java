package com.example.demo.Controller;
import com.example.demo.Data.Dog;
import com.example.demo.Data.User;
import com.example.demo.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }
    @GetMapping("/users/lastname")
    public List<User> getAllDogsSortedByName() {
        return userService.findAllByOrderByFirstNameAsc();
    }

    @GetMapping("/users/firstbreed")
    public List<User> getAllDogsSortedByBreed() {
        return userService.findAllByOrderByLastNameAsc();
    }

    @GetMapping("/users/id")
    public List<User> getAllDogsSortedById() {
        return userService. findAllByOrderByIdAsc();
    }

    @PostMapping("/users/save/{id}")
    public User saveUsers(@PathVariable("id") Long id) {
        User user = new User();
        user.setId(id);
        return userService.saveUser(user);
    }
}

