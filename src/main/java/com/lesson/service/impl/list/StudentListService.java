package com.lesson.service.impl.list;

import com.lesson.models.Student;
import com.lesson.models.Teacher;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import static com.lesson.service.impl.array.StudentService.teacherService;
import static com.lesson.util.ServiceUtil.setGender;

public class StudentListService {


    public List<Student> remove(List<Student> students, String name, String surname) {
        // todo cevirdim foreache                                                                                    +++
        for (Student student : students) {
            if (!(student.getName().equals(name) && student.getSurname().equals(surname))) {
                students.add(student);
            }
        }
        return students;
    }


    public Student create() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Sagirdin adini daxil edin: ");
        String name = scanner.nextLine();
        System.out.println("Sagirdin soyadini daxil edin: ");
        String surname = scanner.nextLine();
        System.out.println("Sagirdin yasini daxil edin: ");
        int age = scanner.nextInt();
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Sagirdin sinifini daxil edin: ");
        String clas = scanner1.nextLine();

        return new Student(name, surname, age, setGender(scanner1, "student"), clas);
    }


    public Student update(UUID teacherId, UUID studentId) {
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        Student student = getById(teacherId, studentId);

        while (loop) {
            System.out.println("Sagirdin adini/soyadini/yasini/sinifi deyisdirirsizse hemin yazilan tipde qeyd edin: ");
            String updatedDate = scanner.nextLine();
            if ("adini".equals(updatedDate)) {
                System.out.println("sagirdin yeni adini daxil edin: ");
                student.setName(scanner.nextLine());
                System.out.println("update olundu");
            } else if ("soyadini".equals(updatedDate)) {
                student.setSurname(scanner.nextLine());
                System.out.println("update olundu");
            } else if ("yasini".equals(updatedDate)) {
                student.setAge(scanner.nextInt());
                System.out.println("update olundu");

            } else if ("sinifini".equals(updatedDate)) {
                student.setClas(scanner.nextLine());
                System.out.println("update olundu");
            } else if ("gender".equals(updatedDate)) {
                student.setGender(setGender(scanner, "student"));
                System.out.println("update olundu");
            } else {
                System.out.println("Yanlis daxil etdiniz, yeniden cehd edin.");
            }
            System.out.println("Eger yeniden update etmek isteyirsense 'he' eks halda 'yox' yaz.");
            String continueLoop = scanner.nextLine();
            if ("yox".equals(continueLoop)) {
                loop = false;

            }
        }
        student.setModifyAt(LocalDateTime.now());

        return student;

    }

    public Student getWithNameAndSurname(List<Student> students, String name, String surname) {
// todo cevirdim foreache                                                                                            +++
        for (Student student : students) {
            if (student.getName().equals(name) && student.getSurname().equals(surname)) {
                return student;
            }
        }
        return null;
    }


    public Student getById(UUID studentId, UUID teacherId) {
// todo cevirdim foreache                                                                                            +++
        Teacher teacher = teacherService.getById(teacherId);
        List<Student> students = teacher.getStudentList();

        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }


    //todo Liste aid herweyi fordan foreache cevir

}