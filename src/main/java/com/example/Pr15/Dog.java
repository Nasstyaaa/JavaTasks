package com.example.Pr15;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "dogs")
@Entity
@Getter
@Setter
public class Dog {
    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "breed")
    private String breed;

    @ManyToOne
    @JsonIgnore
    public User user;
}
