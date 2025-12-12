package com.lesson.util;



import com.lesson.models.StaticData;
import com.lesson.models.Teacher;
import com.lesson.service.inter.CourseInter;

import java.util.Scanner;

public class ProcessUtil {

    private static Teacher[] teachers = createInitTeacher();


    public static void execute(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        CourseInter courseInter = ServiceUtil.teacherServiceFactory(args[0]);
//        StudentInter studentInter = ServiceUtil.studentServiceFactory(args[0]);
//        while (true) {
//
//
//            System.out.println("Eger teacher yaratmaq isteyirsense create yaz\n" +
//                    "teacher ve ya studenti update etmek isteyirsense update yaz \n" +
//                    "studenti silmek isteyirsinizse remove yazin\n" +
//                    "studenti ad soyadina gore tapmaq isteyirsizse find yazin\n" +
//                    "eks halda yeniden sorusulacaq \n" +
//                    "sistemden cixmaq isteyirsinizse exit yazin");
//            String action = scanner.nextLine();
//            if ("create".equals(action)) {
//                Teacher teacher = courseInter.create();
//                teachers[getEmptyIndex()] = teacher;
//                cap(teacher, action);
//
//            } else if ("update".equals(action)) {
//                System.out.println("muellimin adini daxil edin: ");
//                String teacherName = scanner.nextLine();
//                System.out.println("muellimin soyadini daxil edin: ");
//                String teacherSurname = scanner.nextLine();
//                Teacher updatedTeacher = courseInter.update(
//                        courseInter.getTeacherByNameAndSurname(teacherName, teacherSurname));
//                cap(updatedTeacher, action);

//            } else if ("find".equals(action)) {
//                System.out.println("muellimin adini daxil edin: ");
//                String teacherName = scanner.nextLine();
//                System.out.println("muellimin soyadini daxil edin: ");
//                String teacherSurname = scanner.nextLine();
//                Teacher teacher = courseInter.getTeacherByNameAndSurname(teacherName, teacherSurname);
//                System.out.println("Sagirdin adini daxil edin: ");
//                String name = scanner.nextLine();
//                System.out.println("Sagirdin soyadini daxil edin: ");
//                String surname = scanner.nextLine();
//                cap(studentInter.getWithNameAndSurname(teacher.getStudents(), name, surname), action);
//
//            } else if ("exit".equals(action)) {
//                System.exit(0);
//
//            } else {
//                System.out.println("zehmet olmasa istediyiniz emeliyyati duzgun daxil edin");
//
//            }
//        }
    }

    private static Teacher[] createInitTeacher() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("kursda neçə muellim iwleyir: ");
        Integer count = scanner.nextInt();

        return teachers;
    }

    private static int getEmptyIndex() {
        for (int i = 0; i < teachers.length; i++) {
            if (teachers[i]== null) {
                return i;

            }

        }
        return 0;
    }

    private static void cap(Object objects, String action) {

        System.out.println(String.format("%s teacher cap olunur: %s", action, objects));


    }

}

