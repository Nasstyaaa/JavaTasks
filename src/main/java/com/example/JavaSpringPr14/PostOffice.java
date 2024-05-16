package com.example.JavaSpringPr14;

import java.util.Date;

public class PostOffice {
    String name;
    String cityName;

    public PostOffice(String name, String cityName) {
        this.name = name;
        this.cityName = cityName;
    }

    public String getName() {
        return name;
    }

    public String getCityName() {
        return cityName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
