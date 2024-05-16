package com.example.demo.Controller;

import com.example.demo.Data.Dog;
import com.example.demo.Data.User;
import com.example.demo.Service.DogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DogController {
    private DogServiceImpl dogService;


    @Autowired
    public DogController(DogServiceImpl dogService) {
        this.dogService = dogService;
    }


    @GetMapping(value = "/dog/{dogId}/user")
    public @ResponseBody User getDogUser(@PathVariable("dogId") Long dogId){
        return dogService.getUserByDog(dogId);
    }

    @GetMapping(value = "/dogs")
    public List<Dog> getDogs() {
        return dogService.getDogs();
    }

    @GetMapping("/dogs/name")
    public List<Dog> getAllDogsSortedByName() {
        return dogService.findAllByOrderByNameAsc();
    }

    @GetMapping("/dogs/breed")
    public List<Dog> getAllDogsSortedByBreed() {
        return dogService.findAllByOrderByBreedAsc();
    }

    @GetMapping("/dogs/id")
    public List<Dog> getAllDogsSortedById() {
        return dogService.findAllByOrderByIdAsc();
    }
    @PostMapping("/dogs/save/{id}")
    public Dog saveDogs(@PathVariable("id") Long id) {
        Dog dog = new Dog();
        dog.setId(id);
        return dogService.saveDog(dog);
    }
}