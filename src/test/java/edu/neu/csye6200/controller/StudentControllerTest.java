package edu.neu.csye6200.controller;

import edu.neu.csye6200.model.Person;
import edu.neu.csye6200.model.Student;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentControllerTest {
    private static final List<String> csvList = new ArrayList<>();
    private static final String dir = "./src/test/resources/";
    private static final String CSVTitles = "studentID,name,age,gpa";

    @BeforeAll
    static void init() {
        csvList.add(CSVTitles);
        csvList.add("1,Bob,23,3.2");
    }

    @Test
    void addStudent() {
        StudentController sc = new StudentController();
        sc.addStudent(new Student(23, "Bob", 3.2, 1));
        Person p = sc.getStudents().get(0);
        assertNotEquals(null, p);
    }

    @Test
    void addStudentByParam() {
        StudentController sc = new StudentController();
        sc.addStudent(23, "Bob", 3.2, 1);
        Person p = sc.getStudents().get(0);
        assertNotEquals(null, p);
    }

    @Test
    void createStudents() {
        StudentController sc = new StudentController();
        sc.createStudents(dir+"students.csv");
        assertEquals(2, sc.getStudents().size());
        Person p = sc.getStudents().get(1);
        assertNotEquals(null, p);
    }

    @Test
    void getStudent() {
        StudentController sc = new StudentController();
        Person p = sc.getStudent(csvList.get(1));
        assertNotEquals(null, p);
    }
}