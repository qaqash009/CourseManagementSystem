package com.lesson.service.inter;


import com.lesson.models.Teacher;

public interface TeacherInter {
    Teacher create();

    Teacher update(Teacher teacher);

    Teacher getByNameAndSurname(String name, String surname, Teacher[] teachers);
}
