package edu.neu.csye6200.model;

import java.util.ArrayList;
import java.util.List;

public class Group {
        private Teacher teacher;
        private List<Student> students;
        private int groupSize;

  public Group(Teacher teacher, List<Student> students, int groupSize) {
    this.teacher = teacher;
    this.students = students;
    this.groupSize = groupSize;
  }

  public void setGroupSize(int groupSize) {
            this.groupSize = groupSize;
        }

        public int getGroupSize() {
            return this.groupSize;
        }

        public void addStudents(Student s) {
            students.add(s);
        }

  public void addStudentList(List<Student> studentList) {
    students.addAll(studentList);
  }

        public void assignTeacher(Teacher t) {
            teacher = t;
        }

        public Teacher getTeacher() {
            return this.teacher;
        }

        public List<Student> getStudents() {
            return this.students;
        }

        @Override
        public String toString() {
            return students.toString();
        }




}
