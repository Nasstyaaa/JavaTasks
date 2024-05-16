package com.example.demo.Service;

import com.example.demo.Data.User;
import com.example.demo.Data.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@Slf4j
@Transactional
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final EmailServiceImpl emailService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, EmailServiceImpl emailService) {
        log.info("Initializing a userRepository");
        this.userRepository = userRepository;
        this.emailService = emailService;
    }

    public User saveUser(User user) {
        User savedUser = userRepository.save(user);
        log.info("A new user has been saved");
        emailService.sendMailUser("A new user has been saved with ID: " + savedUser.getId());
        return savedUser;
    }

    public void exportUsers() {
        List<User> users = userRepository.findAll();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("C:\\Users\\Anna\\IdeaProjects\\Pr18\\src\\main\\Files\\users.json"), users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<User> getUsers() {
        List<User> users = userRepository.findAll();
        log.info("Get list of users");
        return users;
    }

    public List<User> findAllByOrderByFirstNameAsc() {
        List<User> users = userRepository.findAllByOrderByFirstNameAsc();
        log.info("Get sorted list of users by firstname");
        return users;
    }

    public List<User> findAllByOrderByLastNameAsc() {
        List<User> users = userRepository.findAllByOrderByLastNameAsc();
        log.info("Get sorted list of users by lastname");
        return users;
    }

    public List<User> findAllByOrderByIdAsc() {
        List<User> users = userRepository.findAllByOrderByIdAsc();
        log.info("Get sorted list of users by id");
        return users;
    }
}
