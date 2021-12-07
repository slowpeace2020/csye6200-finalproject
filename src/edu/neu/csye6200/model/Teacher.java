package edu.neu.csye6200.model;

public class Teacher extends Person {
    private int credits;
    private int teacherID;

    public Teacher(){}

    public Teacher(int teacherID) {
        this.teacherID = teacherID;
    }

    public Teacher(int age, String name, int credits, int teacherID) {
        super(age, name);
        this.credits = credits;
        this.teacherID = teacherID;
    }

    public Teacher(int age, String name) {
        super(age, name);
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }
}

