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
        // todo TYPE EGER TEACHERDISE TEACHERSRVICE ICERISINDE UPDATE METGODUNU CAGIR
        // TODO TYPE EGER STUDENTDISE STUDENTSERVISIN ICERISNDE UPDATE MT SIN CAGIR


    }

    // TODO REMOVE METHODU YARAT
    // todo REMOVE METHODU QEBUL EDECEK STRING TYPE UUID TEACHERID STRING NAME STRING SURNAME
}

