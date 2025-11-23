package com.lesson.models;

public class Student extends Person {

    private String clas;

    public Student() {


    }

    public Student(String name, String surname, int age, Gender gender, String clas) {
        super(name, surname, age, gender);
        this.clas = clas;
    }

    public Student(String name, String surname, int age, String clas) {
    }


    public String getClas() {
        return this.clas;
    }


    public void setClas(String clas) {
        this.clas = clas;
    }

    public String toString() {
        return  " Wagirdin adini: " + super.getName() +
                " Wagirdin soyadini qeyd edin:  " + super.getSurname() +
                " Wagirdin yawini qeyd edin:  " + super.getAge() +
                " Wagirdin sinifini: " + this.clas +
                " Wagirdin cinsi: " + super.getGender();

    }
}


