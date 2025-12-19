package com.lesson.models;

import java.util.ArrayList;
import java.util.List;

public final class StaticData {
    public static Teacher[] teachers;
    public static List<Teacher> teacherList;

    private StaticData() {
    }

    public static void getTeachers(Integer count) {
        if (count == null) {
            teachers = new Teacher[1];
        }
        teachers = new Teacher[count];
    }

    public static void getTeachers() { teacherList = new ArrayList<>(); }


}
