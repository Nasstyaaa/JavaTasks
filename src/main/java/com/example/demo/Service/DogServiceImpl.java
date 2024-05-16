package com.example.demo.Service;

import com.example.demo.Data.Dog;
import com.example.demo.Data.DogRepository;
import com.example.demo.Data.User;
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
public class DogServiceImpl implements DogService{
    private final DogRepository dogRepository;
    private final EmailServiceImpl emailService;

    @Autowired
    public DogServiceImpl(DogRepository dogRepository, EmailServiceImpl emailService) {
        log.info("Initializing a dogRepository");
        this.dogRepository = dogRepository;
        this.emailService = emailService;
    }


    public Dog saveDog(Dog dog) {
        Dog savedDog = dogRepository.save(dog);
        System.out.println(savedDog);
        emailService.sendMailDog("A new dog has been saved with ID: " + savedDog.getId());
        return savedDog;
    }

    public void exportDogs() {
        List<Dog> dogs = dogRepository.findAll();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("C:\\Users\\Anna\\IdeaProjects\\Pr18\\src\\main\\Files\\dogs.json"), dogs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Dog> getDogs() {
        List<Dog> dogs = dogRepository.findAll();
        log.info("Get list of dogs");
        return dogs;
    }
    public List<Dog> findAllByOrderByNameAsc() {
        List<Dog> dogs = dogRepository.findAllByOrderByNameAsc();
        log.info("Get sorted list of dogs by name");
        return dogs;
    }

    public List<Dog> findAllByOrderByBreedAsc() {
        List<Dog> dogs = dogRepository.findAllByOrderByBreedAsc();
        log.info("Get sorted list of dogs by breed");
        return dogs;
    }

    public List<Dog> findAllByOrderByIdAsc() {
        List<Dog> dogs = dogRepository.findAllByOrderByIdAsc();
        log.info("Get sorted list of dogs by id");
        return dogs;
    }

    public User getUserByDog(Long dogId) {
        log.info("Find all user's dogs");
        return dogRepository.findById(dogId).orElseThrow(() ->
                new IllegalStateException("Dog with this id not found")).getUser();
    }
}
