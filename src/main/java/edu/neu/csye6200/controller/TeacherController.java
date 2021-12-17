package edu.neu.csye6200.controller;

import edu.neu.csye6200.model.Teacher;
import edu.neu.csye6200.utils.FileUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author jiaogong
 */
public class TeacherController extends Controller<Teacher> {
   private  List<Teacher> teachers;
  private static String defaultFilePath =System.getProperty("user.dir")+"/data/teachers.csv";

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
//    System.out.println(tempTeachers);

  }

  @Override
  public List<Teacher> getList() {
    return teachers;
  }

  @Override
  public void add(Teacher teacher) {
      teachers.add(teacher);
      add(teacher.csvLine());
  }

  public void add(String  teacher) {
    FileUtil.writeTextFile(teacher,defaultFilePath);
  }

  @Override
  public void update(Teacher teacher) {
    for(int i=0;i<teachers.size();i++){
      Teacher cur =  teachers.get(i);
      if(cur.getTeacherID()==teacher.getTeacherID()){
        teachers.set(i,teacher);
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
