package com.lesson.service.impl.array;



import com.lesson.models.Student;
import com.lesson.models.Teacher;
import com.lesson.service.inter.TeacherInter;

import java.time.LocalDateTime;
import java.util.Scanner;

import static com.lesson.util.ServiceUtil.setGender;


public class TeacherService implements TeacherInter {
    @Override
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

    @Override

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

    @Override
    public Teacher getByNameAndSurname(String name, String surname, Teacher[] teachers) {
        for (int i = 0; i < teachers.length; i++) {
            if (teachers[i].getName().equals(name) && teachers[i].getSurname().equals(surname)) {
                return teachers[i];
            }
        }
        return null;
    }


}

