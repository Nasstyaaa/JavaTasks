package com.example.demo.Service;

import com.example.demo.Data.Dog;
import com.example.demo.Data.User;

import java.util.List;

public interface DogService {
    List<Dog> getDogs();
    Dog saveDog(Dog dog);
    List<Dog> findAllByOrderByNameAsc();
    List<Dog> findAllByOrderByBreedAsc();
    List<Dog> findAllByOrderByIdAsc();
    User getUserByDog(Long dogId);
}
