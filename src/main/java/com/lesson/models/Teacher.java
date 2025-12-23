package com.lesson.models;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Teacher extends Person {

    private Double salary;
    private Student[] students;
    private List<Student> studentList;

    public Teacher(String name, String surname, int age, Gender gender, Double salary, List<Student> students) {
        super(name, surname, age, gender);
        this.salary = salary;
        this.students = students;
    }
}
