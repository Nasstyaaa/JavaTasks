package com.example.Pr12;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        FileTranslator translator = new FileTranslator(args[0], args[1]);
        translator.initiate();
        translator.cleanFile();
    }
}