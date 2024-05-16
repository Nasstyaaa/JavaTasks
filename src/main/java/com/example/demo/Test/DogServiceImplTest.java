package com.example.demo.Test;

import com.example.demo.Data.Dog;
import com.example.demo.Data.User;
import com.example.demo.Data.DogRepository;
import com.example.demo.Data.UserRepository;
import com.example.demo.Service.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DogServiceImplTest {
    @Mock
    public DogRepository dogRepository;
    @Mock
    public EmailServiceImpl emailService;

    @Test
    void getDogs(){
        Dog dog1 = new Dog();
        dog1.setName("Bob");
        Dog dog2 = new Dog();
        dog2.setName("Jack");
        List<Dog> dogs = Arrays.asList(dog1, dog2);

        when(dogRepository.findAll()).thenReturn(dogs);
        DogService dogService = new DogServiceImpl(dogRepository, emailService);

        assertEquals(dogs, dogService.getDogs());
    }

    @Test
    void saveUser(){
        Dog dog = new Dog();
        dog.setName("Bob");
        dog.setBreed("Mops");

        when(dogRepository.save(dog)).thenReturn(dog);
        DogService dogService = new DogServiceImpl(dogRepository, emailService);

        Dog savedDog = ((DogServiceImpl) dogService).saveDog(dog);

        assertEquals(dog, savedDog);
        Mockito.verify(emailService).sendMailDog(Mockito.anyString());
    }

    @Test
    void findAllByOrderByFirstNameAsc(){
        Dog dog1 = new Dog();
        dog1.setName("Bob");
        Dog dog2 = new Dog();
        dog2.setName("Jack");
        List<Dog> dogs = Arrays.asList(dog1, dog2);

        when(dogRepository.findAllByOrderByNameAsc()).thenReturn(dogs);
        DogService dogService = new DogServiceImpl(dogRepository, emailService);

        assertEquals(dogs, dogService.findAllByOrderByNameAsc());
    }

    @Test
    void findAllByOrderByIdAsc(){
        Dog dog1 = new Dog();
        dog1.setName("Bob");
        Dog dog2 = new Dog();
        dog2.setName("Jack");
        List<Dog> dogs = Arrays.asList(dog1, dog2);

        when(dogRepository.findAllByOrderByBreedAsc()).thenReturn(dogs);
        DogService dogService = new DogServiceImpl(dogRepository, emailService);

        assertEquals(dogs, dogService.findAllByOrderByBreedAsc());
    }

    @Test
    void findAllByOrderByLastNameAsc(){
        Dog dog1 = new Dog();
        dog1.setName("Bob");
        Dog dog2 = new Dog();
        dog2.setName("Jack");
        List<Dog> dogs = Arrays.asList(dog1, dog2);

        when(dogRepository.findAllByOrderByIdAsc()).thenReturn(dogs);
        DogService dogService = new DogServiceImpl(dogRepository, emailService);

        assertEquals(dogs, dogService.findAllByOrderByIdAsc());
    }

    @Test
    void getUserByDog(){
        User user = new User();
        user.setFirstName("Vasya");
        Dog dog = new Dog();
        dog.setUser(user);

        when(dogRepository.findById(anyLong())).thenReturn(Optional.of(dog));
        DogService dogService = new DogServiceImpl(dogRepository, emailService);

        User result = dogService.getUserByDog(1L);

        assertEquals(user, result);
    }
}
