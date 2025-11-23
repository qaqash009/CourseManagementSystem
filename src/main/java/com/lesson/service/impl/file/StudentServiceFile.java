package com.lesson.service.impl.file;


import com.lesson.models.Student;
import com.lesson.service.inter.StudentInter;

public class StudentServiceFile implements StudentInter {
    @Override
    public Student create() {
        return null;
    }

    @Override
    public Student update(Student student) {
        return null;
    }

    @Override
    public Student[] remove(Student[] students, String name, String surname) {
        return new Student[0];
    }

    @Override
    public Student getWithNameAndSurname(Student[] students, String name, String surname) {
        return null;
    }
}
