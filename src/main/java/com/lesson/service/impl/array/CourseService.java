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

    // todo add ele studenti ayrica

    public void addStudent(List<Student> students, Student student) {
        students.add(student);
    }


    public void create() {
        teacherService.create();
    }

    @Override
    public void update(UUID teacherId) {
        Scanner scanner = new Scanner(System.in);
        Teacher teacher = teacherService.getById(teacherId);
        boolean loop = true;

        while (loop) {
            // todo evde idris edecek ETDIM  +++
            System.out.println("Muellimin ad, soyad, yas, sinif, gen'ni deyisdirirsiniz ? ('gen'i kisi/qadin): ");
            String updatedField = scanner.nextLine();

            if ("ad".equalsIgnoreCase(updatedField)) {
                System.out.println("Muellimin yeni adini daxil edin: ");
                teacher.setName(scanner.nextLine());
                System.out.println("Update olundu ");
            } else if ("soyad".equalsIgnoreCase(updatedField)) {
                System.out.println("Muellimin yeni soyadini daxil edin: ");
                teacher.setSurname(scanner.nextLine());
                System.out.println("Update olundu ");
            } else if ("yas".equalsIgnoreCase(updatedField)) {
                System.out.println("Muellimin yeni yasini daxil edin: ");
                teacher.setAge(scanner.nextInt());
                System.out.println("Update olundu ");
            } else if ("kisi".equalsIgnoreCase(updatedField)) {
                System.out.println("Muellimin genini daxil edin: ");
                teacher.setGender(Gender.MEN);
                System.out.println("Update olundu ");
            }else if ("qadin".equalsIgnoreCase(updatedField)) {
                System.out.println("Muellimin genini daxil edin: ");
                    teacher.setGender(Gender.WOMEN);
                System.out.println("Update olundu ");
            }
            System.out.println("Yeniden update etmek isteyirsinizse 'he', eks halda 'yox' yazin: ");
            String continueLoop = scanner.nextLine();
            if ("yox".equalsIgnoreCase(continueLoop)) {
                loop = false;
            }
        }
        teacher.setModifyAt(LocalDateTime.now());

    }

    public void studentUpdate(UUID studentId) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("update etmek istediyiniz sagirdin ad soyadini yazin : ");
        String studentName = scanner.nextLine();
        String studentSurname = scanner.nextLine();
        StudentService studentService = new StudentService();

        //todo getById methodu yarat

        Student student = studentService.getById(studentId);
        studentService.update(student);
    }

    @Override
    public Teacher getTeacherByNameAndSurname(String name, String surname) {
        for (int i = 0; i < teachers.length; i++) {
            if (teachers[i].getName().equals(name) && teachers[i].getSurname().equals(surname)) {
                return teachers[i];
            }
        }
        return null;
    }


}

