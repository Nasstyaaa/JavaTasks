package com.example.JavaSpringPr14;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/home/office")
public class PostOfficeController {
    List<PostOffice> offices = new ArrayList<>();
    @PostMapping("/create")
    public PostOffice createObject(@RequestParam("name") String name, @RequestParam("cityName") String cityName) {
        PostOffice office = new PostOffice(name, cityName);
        offices.add(office);
        return office;
    }

    @DeleteMapping("/delete")
    public void deleteObject() {
        if (!offices.isEmpty()) {
            offices.remove(offices.size() - 1);
        }
    }

    @GetMapping("/show")
    public List<PostOffice> showAllObjects() {
        return offices;
    }
}
