package com.lesson.service.impl.array;

import com.lesson.models.Gender;
import com.lesson.models.Student;
import com.lesson.models.Teacher;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.UUID;

import static com.lesson.models.StaticData.teachers;
import static com.lesson.util.ServiceUtil.setGender;

public class TeacherService {

    public Teacher create() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Muellimin adini daxil edin: ");
        String name = scanner.nextLine();

        System.out.println("Muellimin soyadini daxil edin: ");
        String surname = scanner.nextLine();

        System.out.println("Muellimin yasini daxil edin: ");
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();

        System.out.println("Muellimin maasini daxil edin: ");
        Double sallary = sc.nextDouble();
        return new Teacher(name, surname, age, setGender(scanner, "teacher"), sallary, createStudents());

    }

    private Student[] createStudents() {
        StudentService studentService = new StudentService();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Sagirdlerin sayini qeyd edin: ");
        int count = scanner.nextInt();

        Student[] stundets = new Student[count];
        for (int i = 0; i < stundets.length; i++) {
            stundets[i] = studentService.create();

        }
        return stundets;
    }

    public void update(UUID teacherId) {
        Scanner scanner = new Scanner(System.in);
        Teacher teacher = getById(teacherId);
        boolean loop = true;

        while (loop) {
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
            } else if ("qadin".equalsIgnoreCase(updatedField)) {
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

    public Teacher getTeacherByNameAndSurname(String name, String surname) {
        for (int i = 0; i < teachers.length; i++) {
            if (teachers[i].getName().equals(name) && teachers[i].getSurname().equals(surname)) {
                return teachers[i];
            }
        }
        return null;
    }

    public Student[] addStudent(Student[] students, Student student) {
        Student[] students1 = new Student[students.length + 1];
        for (int i = 0; i < students1.length; i++) {
            students1[i] = students[i];
        }
        students1[students.length] = student;
        return students1;
    }


    public Teacher update(Teacher teacher) {
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            System.out.println("Muellimin adinimi yoxsa soyadinimi deyisdirirsiniz? ('ad' və ya 'soyad' yazın): ");
            String updatedField = scanner.nextLine();

            if ("ad".equalsIgnoreCase(updatedField)) {
                System.out.println("Muellimin yeni adini daxil edin: ");
                teacher.setName(scanner.nextLine());
                System.out.println("Update olundu ");
            } else if ("soyad".equalsIgnoreCase(updatedField)) {
                System.out.println("Muellimin yeni soyadini daxil edin: ");
                teacher.setSurname(scanner.nextLine());
                System.out.println("Update olundu ");
            }
// TODO STUDENT UPDATE BURADAN SILINSIN VE TEACHERIN DIGER FIELDLERI BURA ELAVE EDILISIN
            System.out.println("update etmek istediyiniz sagirdin ad soyadini yazin : ");
            String studentName = scanner.nextLine();
            String studentSurname = scanner.nextLine();
            StudentService studentService = new StudentService();
            Student student = studentService.getWithNameAndSurname(teacher.getStudents(), studentName, studentSurname);
            studentService.update(student);
            System.out.println("Yeniden update etmek isteyirsinizse 'he', eks halda 'yox' yazin: ");
            String continueLoop = scanner.nextLine();
            if ("yox".equalsIgnoreCase(continueLoop)) {
                loop = false;
            }
        }
        teacher.setModifyAt(LocalDateTime.now());

        return teacher;
    }

    public Teacher getByNameAndSurname(String name, String surname, Teacher[] teachers) {
        for (int i = 0; i < teachers.length; i++) {
            if (teachers[i].getName().equals(name) && teachers[i].getSurname().equals(surname)) {
                return teachers[i];
            }
        }
        return null;
    }

    public Teacher getById(UUID teacherId) {
        for (int i = 0; i < teachers.length; i++) {
            if (teachers[i].getId().equals(teacherId)) {
                return teachers[i];
            }
        }
        return null;
    }


}
