package com.example.Pr12;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
@Component
public class FileTranslator {
    private String file1Path;
    private String file2Path;
    public FileTranslator(String path1, String path2){
        this.file1Path = path1;
        this.file2Path = path2;
    }
    public String traslateFile(String filePath) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] fileBytes = Files.readAllBytes(Paths.get(filePath));
            byte[] hashBytes = digest.digest(fileBytes);
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
    @PostConstruct
    public void initiate() {
        try {
            if (!Files.exists(Path.of(file1Path))) {
                Files.write(Paths.get(file2Path), "null".getBytes());
            }
            String hash = traslateFile(file1Path);
            Files.write(Paths.get(file2Path), hash.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @PreDestroy
    public void cleanFile(){
        try{
            Files.delete(Path.of(file1Path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
