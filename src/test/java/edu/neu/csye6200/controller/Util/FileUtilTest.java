package edu.neu.csye6200.controller.Util;

import edu.neu.csye6200.model.Person;
import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.model.Teacher;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileUtilTest {

    private static final String dir = "./src/test/resources/";

    @Test
    void writeAndReadStudent() {
        String filename  = dir + "students.csv";
        Person st = new Student(1, "Bob", 3.2, 1);
        List<String> csvString = new ArrayList<>();
        String titleLine = "studentID,name,age,gpa";
        String csvline = "1,Bob,23,3.2";
        csvString.add(titleLine);
        csvString.add(csvline);
        FileUtil.write(filename, csvString);
        List<String> line = FileUtil.read(filename);
        assertEquals(csvString, line);
    }

    @Test
    void writeAndReadTeacher() {
        String filename  = dir + "teachers.csv";
        Person st = new Teacher(44, "Bob", 4, 1);
        List<String> csvString = new ArrayList<>();
        String titleLine = "teacherID,name,age,credit";
        String csvline = "1,Bob,45,3.2";
        csvString.add(titleLine);
        csvString.add(csvline);
        FileUtil.write(filename, csvString);
        List<String> line = FileUtil.read(filename);
        assertEquals(csvString, line);
    }
}