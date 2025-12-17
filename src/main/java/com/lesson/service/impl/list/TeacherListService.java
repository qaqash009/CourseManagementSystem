package com.lesson.service.impl.list;

import com.lesson.models.Student;
import com.lesson.service.impl.array.StudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherListService {

    private List<Student> createStudents() {
        StudentService studentService = new StudentService();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Sagirdlerin sayini qeyd edin: ");
        int count = scanner.nextInt();
        scanner.nextLine();

        List<Student> studentsList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            Student student = studentService.create();
            studentsList.add(student);
        }

        return studentsList;

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
