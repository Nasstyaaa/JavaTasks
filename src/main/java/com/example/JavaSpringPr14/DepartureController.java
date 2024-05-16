package com.example.JavaSpringPr14;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/home/departure")
public class DepartureController {
    List<Departure> departures= new ArrayList<>();
    @PostMapping("/create")
    public Departure createObject(@RequestParam("type") String type, @RequestParam("departureDate") String departureDate) {
        System.out.println(type);
        System.out.println(departureDate);
        Departure departure = new Departure(type, departureDate);
        System.out.println(departure);
        departures.add(departure);
        return departure;
    }

    @DeleteMapping("/delete")
    public void deleteObject() {
        if (!departures.isEmpty()) {
            departures.remove(departures.size() - 1);
        }
    }

    @GetMapping("/show")
    public List<Departure> showAllObjects() {
        return departures;
    }
}

