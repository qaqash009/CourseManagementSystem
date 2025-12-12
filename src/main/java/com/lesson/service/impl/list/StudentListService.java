package com.lesson.service.impl.list;

import com.lesson.models.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentListService{

    public List<Student> remove(List<Student> students, String name, String surname) {
        List<Student> newStudentList = new ArrayList<>(students.size());
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getName().equals(name) && student.getSurname().equals(surname)) {
                newStudentList.add(student);
            }
        }
        return newStudentList;
    }

    public Student create() {
        return null;
    }

    public Student[] remove(Student[] students, String name, String surname) {
        return new Student[0];
    }

    public Student update(Student student) {
        return null;
    }

    public Student getWithNameAndSurname(Student[] students, String name, String surname) {
        return null;
    }
}

