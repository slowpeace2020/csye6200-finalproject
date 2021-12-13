package edu.neu.csye6200.controller;

import edu.neu.csye6200.model.Teacher;
import edu.neu.csye6200.utils.FileUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TeacherController extends Controller<Teacher> {
   private  List<Teacher> teachers;
   private static String defaultFilePath ="teachers.csv";

  public TeacherController(){
    this(defaultFilePath);
  }

  /**
   * get teacher list by reading csv file
   * @param filePath
   */
  public TeacherController(String filePath){
    teachers= new ArrayList<>();
    List<String> tempTeachers = FileUtil.readTextFile(filePath);
    tempTeachers.forEach(teacher -> teachers.add(new Teacher(teacher)));
    System.out.println(tempTeachers);

  }

  @Override
  public List<Teacher> getList() {
    return teachers;
  }

  @Override
  public void add(Teacher teacher) {
      teachers.add(teacher);
  }

  public void add(String  teacher) {
    FileUtil.writeTextFile(teacher,defaultFilePath);
  }

  @Override
  public void update(Teacher teacher) {
    for(Teacher cur:teachers){
      if(cur.getTeacherID()==teacher.getTeacherID()){
        teachers.remove(cur);
        teachers.add(teacher);
        break;
      }
    }
    Collections.sort(teachers,(a,b)->a.getTeacherID()-b.getTeacherID());
    FileUtil.writeTextFile("",defaultFilePath,false);
    for(Teacher cur:teachers){
      FileUtil.writeTextFile(cur.toString(),defaultFilePath);
    }
  }

  @Override
  public Teacher detail(Teacher teacher) {
    for(Teacher cur:teachers){
      if(cur.getTeacherID()==teacher.getTeacherID()){
        return cur;
      }
    }

    return teacher;
  }

  @Override
  public Teacher query(Teacher teacher) {
    return detail(teacher);
  }


  public static void main(String[] args) {
    TeacherController controller = new TeacherController();
    System.out.println(controller.teachers);
  }
}
