package com.lesson.models;


public final class StaticData {
    private static Teacher[] teachers;

    private  StaticData() {
    }

    public static Teacher[] getTeachers(Integer count) {
        if (count == null) {
            return new Teacher[1];
        }
        return new Teacher[count];
    }
}
