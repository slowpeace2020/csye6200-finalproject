package edu.neu.csye6200.model;

public class Student extends Person {
    private double gpa;

    public Student(){}

    public Student(int gpa) {
        this.gpa = gpa;
    }

    public Student(int age, String name, int gpa) {
        super(age, name);
        this.gpa = gpa;
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

    @Override
    public String toString() {
        return "Student{" +
                "age=" + this.getAge() +
                "grade=" + gpa +
                ", name='" + this.getName() + '\'' +
                '}';
    }
}
