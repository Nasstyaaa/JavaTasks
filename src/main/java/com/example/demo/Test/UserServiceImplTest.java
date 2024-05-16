package com.example.demo.Test;

import com.example.demo.Data.Dog;
import com.example.demo.Data.User;
import com.example.demo.Data.UserRepository;
import com.example.demo.Service.EmailServiceImpl;
import com.example.demo.Service.UserService;
import com.example.demo.Service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private EmailServiceImpl emailService;
    @Test
    void getUsers() {

        User user = new User();
        user.setFirstName("Vasya");
        User user2 = new User();
        user2.setFirstName("Dima");
        List<User> users = Arrays.asList(user, user2);

        when(userRepository.findAll()).thenReturn(users);
        UserService userService = new UserServiceImpl(userRepository, emailService);

        assertEquals(2, userService.getUsers().size());
    }

    @Test
    void saveUser(){
        User user = new User();
        user.setFirstName("Vasya");
        user.setLastName("Vasilkov");

        when(userRepository.save(user)).thenReturn(user);
        UserService userService = new UserServiceImpl(userRepository, emailService);

        User savedUser = ((UserServiceImpl) userService).saveUser(user);

        assertEquals(user, savedUser);
        Mockito.verify(emailService).sendMailUser(Mockito.anyString());
    }

    @Test
    void findAllByOrderByFirstNameAsc(){
        User user1 = new User();
        user1.setFirstName("Vasya");
        User user2 = new User();
        user2.setFirstName("Dima");
        List<User> users = Arrays.asList(user1, user2);

        when(userRepository.findAllByOrderByFirstNameAsc()).thenReturn(users);
        UserService userService = new UserServiceImpl(userRepository, emailService);

        assertEquals(users, userService.findAllByOrderByFirstNameAsc());
    }

    @Test
    void findAllByOrderByIdAsc(){
        User user1 = new User();
        user1.setFirstName("Vasya");
        User user2 = new User();
        user2.setFirstName("Dima");
        List<User> users = Arrays.asList(user1, user2);

        when(userRepository.findAllByOrderByIdAsc()).thenReturn(users);
        UserService userService = new UserServiceImpl(userRepository, emailService);

        assertEquals(users, userService.findAllByOrderByIdAsc());
    }

    @Test
    void findAllByOrderByLastNameAsc(){
        User user1 = new User();
        user1.setFirstName("Vasya");
        User user2 = new User();
        user2.setFirstName("Dima");
        List<User> users = Arrays.asList(user1, user2);

        when(userRepository.findAllByOrderByLastNameAsc()).thenReturn(users);
        UserService userService = new UserServiceImpl(userRepository, emailService);

        assertEquals(users, userService.findAllByOrderByLastNameAsc());
    }
}