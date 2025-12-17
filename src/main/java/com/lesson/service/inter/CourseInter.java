package com.lesson.service.inter;


import com.lesson.models.Teacher;

import java.util.UUID;

public interface CourseInter {
    void addStudent(UUID teacherId);

    void create();

    void update(String type, UUID teacherId, UUID studentId);

}
