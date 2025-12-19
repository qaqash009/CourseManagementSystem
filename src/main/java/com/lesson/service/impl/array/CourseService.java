package com.lesson.service.impl.array;


import com.lesson.models.Student;
import com.lesson.models.Teacher;
import com.lesson.service.inter.CourseInter;

import java.util.UUID;


public class CourseService implements CourseInter {

    private static TeacherService teacherService = new TeacherService();
    private static StudentService studentService = new StudentService();

    @Override
    public void addStudent(UUID teacherId) {
        Teacher teacher = teacherService.getById(teacherId);
        Student[] students = teacher.getStudents();
        Student student = studentService.create();
        teacher.setStudents(teacherService.addStudent(students, student));
    }

    @Override
    public void create() {
        teacherService.create();
    }

    @Override
    public void update(String type, UUID teacherId, UUID studentId) {

        if ("muellim".equalsIgnoreCase(type)) {

            teacherService.update(teacherId);

        } else if ("wagird".equalsIgnoreCase(type)) {

            studentService.update(teacherId, studentId);

        }
    }

    @Override
    public void remove(String type, UUID teacherId, String name, String surname) {
        if ("muellim".equalsIgnoreCase(type)) {

            teacherService.remove(name, surname);

        } else if ("wagird".equalsIgnoreCase(type)) {
            studentService.remove(teacherId, name, surname);
        }
    }
}

