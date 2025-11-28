package com.lesson.models;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)


public class Student extends Person {

    private String clas;


    public Student(String name, String surname, int age, Gender gender, String clas) {
        super(name, surname, age, gender);
        this.clas = clas;
    }
}


