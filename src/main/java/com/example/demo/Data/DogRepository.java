package com.example.demo.Data;

import com.example.demo.Data.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DogRepository extends JpaRepository<Dog, Long> {
    List<Dog> findAllByOrderByNameAsc();
    List<Dog> findAllByOrderByBreedAsc();
    List<Dog> findAllByOrderByIdAsc();
}
