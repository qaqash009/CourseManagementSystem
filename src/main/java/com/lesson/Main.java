package com.lesson;

import com.fasterxml.jackson.core.StreamReadFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SequenceWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.lesson.models.Gender;
import com.lesson.models.Student;
import com.lesson.util.ProcessUtil;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {



        Student student = new Student();
        student.setClas("1A");
        Student student2 = new Student();
        student.setClas("1A");
        Set<Student> studentSet = new HashSet<Student>();
        studentSet.add(student2);
        studentSet.add(student);
        studentSet.forEach(System.out::println);




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
//        Student student = new Student("Idris", "ehmedzade", 17, Gender.MEN, "11a");
//        ObjectMapper objectMapper = JsonMapper.builder()

//        .enable(StreamReadFeature.INCLUDE_SOURCE_IN_LOCATION);
//        .disable(StreamReadFeature.AUTO_CLOSE_SOURCE);
//        .build();
//        objectMapper.registerModule(new JavaTimeModule());
////        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
//        SequenceWriter sequenceWriter = objectMapper.writer()
//                .withRootValueSeparator("\n")
//                .writeValues(new File("test.json"));
//        sequenceWriter.write(student);

//        BufferedReader bufferedReader = new BufferedReader(new FileReader("test.json"));
//        String line;
//        while ((line = bufferedReader.readLine()) != null) {
//            Student student = objectMapper.readValue(new FileReader("test.json"), Student.class);
//            System.out.println(student);
//        }

    }
}