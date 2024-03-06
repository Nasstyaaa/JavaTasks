package Pr2;

import java.time.LocalDate;

public class Human {
    //объявление переменных класса
    int age;
    String firstName;
    String lastName;
    LocalDate birthDate;
    int weight;

    //создание конструктора класса
    public Human(int age, String firstName, String lastName, LocalDate birthDate, int weight) {
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.age = age;
        this.lastName = lastName;
        this.weight = weight;
    }
    //создание методов класса
    public String getName() {
        return this.firstName;
    }

    public int getWeight() {
        return this.weight;
    }

    public int getAge() {
        return this.age;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String toString() {
        return (this.getName() + " " + this.getLastName() + " " + this.getWeight() + " " + this.getAge() + " " + this.getBirthDate());
    }
}

