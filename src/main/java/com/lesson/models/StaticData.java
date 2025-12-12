package com.lesson.models;


public final class StaticData {
    public static Teacher[] teachers;

    private StaticData() {
    }

    public static void getTeachers(Integer count) {
        if (count == null) {
            teachers = new Teacher[1];
        }
        teachers = new Teacher[count];
    }
}
