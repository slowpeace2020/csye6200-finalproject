package edu.neu.csye6200.model;

import java.util.*;

public class Classroom {
    private int capacity;

    private  List<Student> studentList = new ArrayList<>();
    private  List<Teacher> teacherList = new ArrayList<>();
    private  List<Group> groupList = new ArrayList<>();

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
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


    public void addTeacher(Teacher teacher){
        teacherList.add(teacher);
    }

    public void delTeacher(Teacher teacher){
        teacherList.remove(teacher);
    }

    public int getNumOfTeachers(){
        return this.teacherList.size();
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }


    public void addGroup(Group group){
        groupList.add(group);
    }

    public void delGroup(Group group){
        groupList.remove(group);
    }

    public int getNumOfGroups(){
        return this.groupList.size();
    }

    public List<Group> getGroupList() {
        return groupList;
    }

}
