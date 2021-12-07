package edu.neu.csye6200.model;

import java.util.*;

public class Classroom {
    private int capacity;

    private static List<Student> studentList = new ArrayList<>();
    private static List<Teacher> teacherList = new ArrayList<>();

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("The classroom capacity is ").append(getCapacity()).append("\n");
        for(Student student : studentList) {
            sb.append(student.toString()).append("\n");
        }
        sb.append("\n");
        for(Person person : studentList) {
            sb.append(person.toString()).append("\n");
        }
        return sb.toString();
    }
}
