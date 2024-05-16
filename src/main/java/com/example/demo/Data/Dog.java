package com.example.demo.Data;

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
    @JoinColumn(name = "user_id")
    @JsonIgnore
    public User user;
}
