package edu.neu.csye6200.model;

public class Teacher extends Person {
    private int credits;

    public Teacher(){}

    public Teacher(int credits) {
        this.credits = credits;
    }

    public Teacher(int age, String name, int credits) {
        super(age, name);
        this.credits = credits;
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

    @Override
    public String toString() {
        return "Teacher{" +
                "age=" + this.getAge() +
                "credits=" + credits +
                ", name='" + this.getName() + '\'' +
                '}';
    }
}

