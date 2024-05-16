package com.example.demo.Test;

import com.example.demo.Service.DogServiceImpl;
import com.example.demo.Service.SchedulerServiceImpl;
import com.example.demo.Service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class SchedulerServiceImplTest {
    @Test
    void doScheduledTask() {
        DogServiceImpl dogService = Mockito.mock(DogServiceImpl.class);
        UserServiceImpl userService = Mockito.mock(UserServiceImpl.class);

        SchedulerServiceImpl schedulerService = new SchedulerServiceImpl(dogService, userService);

        schedulerService.doScheduledTask();

        verify(dogService).exportDogs();
        verify(userService).exportUsers();
    }
}
