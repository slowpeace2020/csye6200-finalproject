package edu.neu.csye6200.controller;

import edu.neu.csye6200.model.ClassRoom;
import edu.neu.csye6200.model.Group;
import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.model.Teacher;
import java.util.List;
import java.util.Map;

public class Test {

  public static void main(String[] args) {
    StudentController studentController = new StudentController();
    List<Student> students = studentController.getList();
    ImmunizationContorller immunizationContorller = new ImmunizationContorller();
    immunizationContorller.getImmunizationInfo(students);
    TeacherController teacherController = new TeacherController();
    List<Teacher> teachers = teacherController.getList();
    GroupController groupController = new GroupController(students,teachers);
    Map<Integer,List<Group>> groups = groupController.getGroups();
    ClassRoomController classRoomController = new ClassRoomController(groups);
    List<ClassRoom> classroomList = classRoomController.getList();
    System.out.println(classroomList);
  }

}
