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


    public void create() {
        teacherService.create();
    }

    @Override
    public void update(String type, UUID teacherId, UUID studentId) {

        if ("muellim".equalsIgnoreCase(type)) {

            teacherService.update(teacherId);

        } else if ("wagird".equalsIgnoreCase(type)) {

            studentService.update(studentId);

        }
        return;

    }

    public Teacher[] remove(String type, UUID teacherId, String name, String surname) {
        Teacher[] newTeachersArr = new Teacher[teacherId.length];
        int count = 0;

        if (!"muellim".equals(type)) {
            return type;
        }

        for (int i = 0; i < teacherId.length; i++) {
            Teacher teacher = teacherId[i];
            if (teacher.getId().equals(teacherId) && teacher.getName().equals(name) && teacher.getSurname().equals(surname)) {
                count++;
            } else {
                if (count > 0) {
                    newTeachersArr[i - 1] = teacherId[i];
                } else {
                    newTeachersArr[i] = teacherId[i];
                }
            }
        }
        return newTeachersArr;
    }

    // TODO REMOVE METHODU YARAT
    // todo REMOVE METHODU QEBUL EDECEK STRING TYPE UUID TEACHERID STRING NAME STRING SURNAME
}

