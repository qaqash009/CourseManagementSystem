package com.lesson.service.impl.list;

import com.lesson.models.Student;
import com.lesson.service.impl.array.StudentService;
import com.lesson.service.inter.StudentInter;

import java.util.ArrayList;
import java.util.List;

public class StudentListService extends StudentService implements StudentInter {

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
}

