package com.lesson.service.impl.list;

import com.lesson.models.Gender;
import com.lesson.models.Student;
import com.lesson.models.Teacher;
import com.lesson.service.impl.array.StudentService;

import java.time.LocalDateTime;
import java.util.*;

import static com.lesson.models.StaticData.teachers;
import static com.lesson.util.ServiceUtil.setGender;

public class TeacherListService {
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

    private List<Student> createStudents() {
        StudentService studentService = new StudentService();
        List<Student> students = new ArrayList<>();
        students.add(studentService.create());

        return students;

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
        List<Teacher> teacherList = new ArrayList<>(Arrays.asList(teachers));
// todo convert array to list                                                                                        +++
        for (Teacher teacher : teacherList) {
            if (teacher.getName().equals(name)
                    && teacher.getSurname().equals(surname)) {
                return teacher;
            }
        }
        return null;
    }


    public List<Student> addStudent(List<Student> students, Student student) {

        students.add(student);
        return students;
    }

    public Teacher getById(UUID teacherId) {
       // todo complite method wrongs List convert to Teacher, teacherList static import and foreach write.          +++
        for (Teacher teacher : teachers) {
            if (teacher.getId().equals(teacherId)) {
                return teacher;
            }
        }
        return null;
    }


    public List<Teacher> remove(List<Teacher> teachers, String name, String surname) {
// todo cevir foreach e                                                                                              +++
        for (Teacher teacher : teachers) {
            if (!(teacher.getName().equals(name)
                    && teacher.getSurname().equals(surname))) {
                teachers.add(teacher);
            }
        }
        return teachers;
    }

}
