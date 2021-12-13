package edu.neu.csye6200.controller;

import edu.neu.csye6200.controller.Util.FileUtil;
import edu.neu.csye6200.model.Person;
import edu.neu.csye6200.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentController {
    private final List<Person> students = new ArrayList<>();

    private static final String CSVTitles = "studentID,name,age,gpa";

    // TODO: timestamp, registration info
    public void addStudent(int age, String name, double gpa, int studentID) {
        Person person = new Student(age, name, gpa, studentID);
        addStudent(person);
    }

    public void addStudent(Person person) {
        students.add(person);
    }

    public List<Person> getStudents() {
        return students;
    }

    public void createStudents(String CSVFilename) {
        students.clear();

        List<String> CSVList = FileUtil.read(CSVFilename);
        // skip title line
        for (int i = 1; i < CSVList.size(); i++) {
            Person p = getStudent(CSVList.get(i));
            if (p!=null)
                addStudent(p);
            else
                throw new NullPointerException("null object");
        }
    }

    public Student getStudent(String CSVString) {
        String name;
        int age, studentID;
        double gpa;
        Student student = null;
        // studentID,name,age,gpa
        Scanner in = new Scanner(CSVString);
        in.useDelimiter(",");
        try {
            studentID = in.nextInt();
            name = in.next();
            age = in.nextInt();
            gpa = in.nextDouble();
            student = new Student(age, name, gpa, studentID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        in.close();

        return student;
    }

    public Person findByStudentID(int studentID) {
        for (Person student : students)
            if (student instanceof Student)
                if (studentID == ((Student) student).getStudentID())
                    return student;

        return null;
    }

    public void remove(int studentID) {
        students.remove(findByStudentID(studentID));
    }

    // TODO: update
//    public void update(int studentID) {
//
//    }
}
