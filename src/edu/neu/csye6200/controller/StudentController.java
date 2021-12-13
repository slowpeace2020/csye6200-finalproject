package edu.neu.csye6200.controller;

import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.model.Teacher;
import edu.neu.csye6200.utils.FileUtil;
import java.util.ArrayList;
import java.util.List;

public class StudentController extends Controller<Student> {
  private  List<Student> students;
  private static String defaultFilePath ="students.csv";
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
    System.out.println(tempStudents);

  }

  @Override
  public void add(Student student) {
    students.add(student);
  }

  @Override
  public void update(Student student) {

  }

  @Override
  public Student detail(Student student) {
    return null;
  }

  @Override
  public Student query(Student student) {
    return null;
  }

  public static void main(String[] args) {
    StudentController controller = new StudentController();
    System.out.println(controller.students);
  }
}
