package com.lesson.service.impl.array;


import com.lesson.models.Gender;
import com.lesson.models.Student;
import com.lesson.models.Teacher;
import com.lesson.service.inter.CourseInter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import static com.lesson.models.StaticData.teachers;


public class CourseService implements CourseInter {

    private static TeacherService teacherService = new TeacherService();
    private static StudentService studentService = new StudentService();

    //todo ovrride ele bu methodu
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
    // todo update student and teacher
    public void update(UUID teacherId,UUID studentId) {


    }

    // bundan istifade etsek o update methodunun ucerisini doldurariq
    public void studentUpdate(UUID studentId) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("update etmek istediyiniz sagirdin ad soyadini yazin : ");
        String studentName = scanner.nextLine();
        String studentSurname = scanner.nextLine();
        StudentService studentService = new StudentService();

        //todo getById methodu yarat

//        Student student = studentService.getById(studentId);
//        studentService.update(student);
    }

// TODO
// teacher ve studenti silmek  bununda methodunu yazmaq
//birde get emeliyyatlari artiq yazilibdir

}

