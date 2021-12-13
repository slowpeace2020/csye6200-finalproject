package edu.neu.csye6200.model;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private Teacher teacher;
    private List<Student> studentList = new ArrayList<>();
    private int groupID;

    public Teacher getTeacher() {
        return this.teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void addStudent(Student student){
        studentList.add(student);
    }

    public void delStudent(Student student){
        studentList.remove(student);
    }

    public int getNumOfStudents(){
        return this.studentList.size();
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }
}
