package com.example.demo.Data;

import com.example.demo.Data.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository  extends JpaRepository<User, Long> {
    List<User> findAllByOrderByFirstNameAsc();
    List<User> findAllByOrderByLastNameAsc();
    List<User> findAllByOrderByIdAsc();
}
