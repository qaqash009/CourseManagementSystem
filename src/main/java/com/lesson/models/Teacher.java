package com.lesson.models;

public class Teacher extends Person {

    private Double salary;
    private Student[] students;

    public Teacher() {

    }
    public Teacher(String name, String surname, int age, Gender gender, Double salary, Student[] students) {
        super(name, surname, age, gender);
        this.salary = salary;
        this.students = students;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return " Muellimin adini: " + super.getName() +
                " Muellimin soyadini:  " + super.getSurname() +
                " Muellimin yawini:  " + super.getAge() +
                " Muellimin sinifini: " + this.salary;
    }
}
