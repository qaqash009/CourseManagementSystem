package com.lesson.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor


public class Person {
    private UUID id;
    private String name;
    private String surname;
    private int age;
    private Gender gender;

    private LocalDateTime createdAt;

    private LocalDateTime modifyAt;

    public Person(String name, String surname, int age, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
    }

    public Person(String name, String surname, int age, String clas, Gender gender) {

        this.id = UUID.randomUUID();
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
        this.createdAt = LocalDateTime.now();
        this.modifyAt = LocalDateTime.now();
    }
}
