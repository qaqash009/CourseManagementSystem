package com.lesson.service.impl.array;


import com.lesson.models.Student;
import com.lesson.service.inter.StudentInter;

import java.time.LocalDateTime;
import java.util.Scanner;

import static com.lesson.util.ServiceUtil.setGender;


public class StudentService implements StudentInter {
    @Override
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

    @Override

    public Student update(Student student) {
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            System.out.println("Sagirdin adini/soyadini/yasini/sinifi deyisdirirsizse hemin yazilan tipde qeyd edin: ");
            String updatedDate = scanner.nextLine();
            if ("adini".equals(updatedDate)) {
                System.out.println("sagirdin yeni adini daxil edin: ");
                student.setSurname(scanner.nextLine());
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
            }
            else {
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
    @Override
    public Student[] remove(Student[] students, String name, String surname) {
        Student[] newStudentsArr = new Student[students.length];
        int count = 0;
        for (int i = 0; i < students.length; i++) {
            Student student = students[i];
            if (student.getName().equals(name) && student.getSurname().equals(surname)) {
                count++;
            } else {
                if (count > 0) {
                    newStudentsArr[i - 1] = students[i];
                } else {
                    newStudentsArr[i] = students[i];
                }
            }
        }
        return newStudentsArr;

    }

    @Override
    public Student getWithNameAndSurname(Student[] students, String name, String surname) {
        for (Student student : students) {
            if (student.getName().equals(name) &&
                    student.getSurname().equals(surname)) {
                return student;
            }

        }
        return null;
    }


}
