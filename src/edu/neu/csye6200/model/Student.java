package edu.neu.csye6200.model;

public class Student extends Person {
    private double gpa;
    private int studentID;

    public Student(){}

    public Student(int studentID) {
        this.studentID = studentID;
    }

    public Student(int age, String name, double gpa, int studentID) {
        super(age, name);
        this.gpa = gpa;
        this.studentID = studentID;
    }

    public Student(int age, String name) {
        super(age, name);
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(int gpa) {
        this.gpa = gpa;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }


}
