package com.lesson;

import com.fasterxml.jackson.core.StreamReadFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.lesson.models.Gender;
import com.lesson.models.Student;
import com.lesson.util.ProcessUtil;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
//        ProcessUtil.execute(args);
//
//        BufferedReader bufferedReader = new BufferedReader(new FileReader("test.txt"));
//        String student = bufferedReader.readLine();
//        student = student.trim();
//
//        if (student.contains("clas")) {
//            String[] students = student.split("=");
//            String netice = students[students.length - 1].replace("}", "");
//            Student student1 = new Student();
//            student1.setClas(netice);
//            System.out.println(netice);
//        }
        Student student = new Student("Idris", "ehmedzade", 17, Gender.MEN, "11a");
        ObjectMapper objectMapper = JsonMapper.builder();

        .enable(SerializationFeature);
        .disable(StreamReadFeature.AUTO_CLOSE_SOURCE);
        .build();
        objectMapper.registerModule(new JavaTimeModule);
        BufferedReader bufferedReader = new BufferedReader(new FileReader("test.json"));

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            Student student = objectMapper.readValue(new FileReader("test.json"), Student.class);
            System.out.println(student);
        }

    }
}