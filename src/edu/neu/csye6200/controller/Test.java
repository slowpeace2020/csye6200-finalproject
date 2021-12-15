package edu.neu.csye6200.controller;

import edu.neu.csye6200.model.Classroom;
import edu.neu.csye6200.model.Group;
import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.model.Teacher;
import edu.neu.csye6200.model.Vaccine;
import java.util.List;
import java.util.Map;

public class Test {

  public static void main(String[] args) {
    StudentController studentController = new StudentController();
    List<Student> students = studentController.getList();
    ImmunizationContorller immunizationContorller = new ImmunizationContorller();
    immunizationContorller.getImmunizationInfo(students);
    List<Vaccine> immuMap = immunizationContorller.getList();
    TeacherController teacherController = new TeacherController();
    List<Teacher> teachers = teacherController.getList();
    GroupController groupController = new GroupController(students,teachers);
    Map<Integer,List<Group>> groups = groupController.getGroups();
    ClassRoomController classRoomController = new ClassRoomController(groups);
    List<Classroom> classroomList = classRoomController.getList();
    System.out.println(classroomList);
  }

}
