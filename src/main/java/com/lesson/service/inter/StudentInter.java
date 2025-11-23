package com.lesson.service.inter;


import com.lesson.models.Student;

public interface StudentInter {
    Student create();

    Student[] remove(Student[] students, String name, String surname);

    Student update(Student student);

    Student getWithNameAndSurname(Student[] students, String name, String surname);

}
