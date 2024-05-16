package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


@Service
@ManagedResource(objectName = "com.example.demo:type=ScheduledTaskService")
public class SchedulerServiceImpl implements SchedulerService {
    DogServiceImpl dog;
    UserServiceImpl user;

    @Autowired
    public SchedulerServiceImpl(DogServiceImpl dogService, UserServiceImpl userService) {
        this.dog = dogService;
        this.user = userService;
    }
    public static void deleteFilesInDirectory(File directory) {
        if (!directory.exists()) {
            System.out.println("Директория не существует: " + directory.getAbsolutePath());
            return;
        }
        if (!directory.isDirectory()) {
            System.out.println("Указанный путь не является директорией: " + directory.getAbsolutePath());
            return;
        }
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                try {
                    Path path = file.toPath();
                    Files.delete(path);
                    System.out.println("Удален файл: " + file.getAbsolutePath());
                } catch (IOException e) {
                    System.err.println("Ошибка при удалении файла: " + file.getAbsolutePath());
                    e.printStackTrace();
                }
            }
        }
    }

    @Scheduled(cron = "0 0/30 * * * ?")
    @Override
    @ManagedOperation
    public void doScheduledTask() {
        File dir = new File("C:/Users/Anna/IdeaProjects/Pr18/src/main/Files");
        deleteFilesInDirectory(dir);
        dog.exportDogs();
        user.exportUsers();
    }
}
