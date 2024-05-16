package com.example.Pr15;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DogController {
    private final DogService dogService;

    @Autowired
    public DogController(DogService dogService) {
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

    @GetMapping(value = "/dogs/{field}")
    public @ResponseBody List<Dog> getDogsBreed(@PathVariable("field") String nameOfField) {
        return dogService.createRequest(nameOfField);
    }
}