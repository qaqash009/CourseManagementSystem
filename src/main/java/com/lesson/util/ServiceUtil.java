package com.lesson.util;

import com.lesson.models.Gender;
import com.lesson.service.impl.array.StudentService;
import com.lesson.service.impl.array.CourseService;
import com.lesson.service.impl.file.StudentServiceFile;
import com.lesson.service.inter.CourseInter;

import java.util.Scanner;

public class ServiceUtil {

    public static Gender setGender(Scanner scanner, String type) {
        String text = "%s cinsini daxil edin: ";
        if (type.equals("student")) {
            text = String.format(text, "Sagirdin");

        }else if (type.equals("teacher")) {
            text = String.format(text, "Muellimin");
        }
        System.out.println(text);
        String gender = scanner.nextLine();
        if ("kisi".equals(gender)) {
            return Gender.MEN;

        } else if ("qadin".equals(gender)) {
            return Gender.WOMEN;

        }
        System.out.println("GENDER YANLIS DAXIL EDILDI");
        return Gender.NOT_SUPPORT;
    }

//    public static StudentInter studentServiceFactory(String type) {
//        if ("array".equals(type)) {
//            return new StudentService();
//        } else if ("file".equals(type)) {
//            return new StudentServiceFile();
//        } else {
//            return new StudentService();
//        }
//    }

    public static CourseInter teacherServiceFactory(String type) {
        if ("array".equals(type)) {
            return new CourseService();
        }
        return new CourseService();
    }



}
