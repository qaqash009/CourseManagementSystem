package com.lesson.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class Person {
    private UUID id;
    private String name;
    private String surname;
    private int age;
    private String clas;
    private Gender gender;

    private LocalDateTime createdAt;

    private LocalDateTime modifyAt;

    public Person(String name, String surname, int age, Gender gender) {
        this.name = name;
    }

    public Person(Long id, String name, String surname, int age, String clas, Gender gender) {

        this.id = UUID.randomUUID();
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.clas = clas;
        this.gender = gender;
        this.createdAt = LocalDateTime.now();
        this.modifyAt = LocalDateTime.now();
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClas() {
        return clas;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getModifyAt() {
        return modifyAt;
    }

    public void setModifyAt(LocalDateTime modifyAt) {
        this.modifyAt = modifyAt;
    }
}
