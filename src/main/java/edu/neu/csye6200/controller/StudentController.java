package edu.neu.csye6200.controller;

import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.model.Teacher;
import edu.neu.csye6200.utils.FileUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author jiaogong
 */
public class StudentController extends Controller<Student> {
  private  List<Student> students;
  private static String defaultFilePath =System.getProperty("user.dir")+"/data/students.csv";
  @Override
  public List<Student> getList() {
    return this.students;
  }

  public StudentController(){
    this(defaultFilePath);
  }

  /**
   * get teacher list by reading csv file
   * @param filePath
   */
  public StudentController(String filePath){
    students= new ArrayList<>();
    List<String> tempStudents = FileUtil.readTextFile(filePath);
    tempStudents.forEach(student -> students.add(new Student(student)));
  }

  @Override
  public void add(Student student) {
    students.add(student);
    System.out.println(student.csvLine());
    FileUtil.writeTextFile(student.csvLine(),defaultFilePath);
  }

  @Override
  public void update(Student student) {
    for(Student cur:students){
      if(cur.getStudentID()==student.getStudentID()){
        students.remove(cur);
        students.add(student);
        break;
      }
    }
    Collections.sort(students,(a,b)->a.getStudentID()-b.getStudentID());
    FileUtil.writeTextFile("",defaultFilePath,false);
    for(Student cur:students){
      FileUtil.writeTextFile(cur.toString(),defaultFilePath);
    }
  }

  @Override
  public Student detail(Student student) {
    for(Student cur:students){
      if(cur.getStudentID()==student.getStudentID()){
        return cur;
      }
    }

    return student;
  }

  @Override
  public Student query(Student student) {
    return detail(student);
  }

  public static void main(String[] args) {
    StudentController controller = new StudentController();
    System.out.println(controller.students);
  }
}
