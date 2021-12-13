package edu.neu.csye6200.controller;

import edu.neu.csye6200.model.Classroom;
import edu.neu.csye6200.model.Group;
import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.model.Teacher;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupController extends Controller<Group> {
  private List<Student> students;
  private List<Teacher> teachers;
  private Map<Integer,List<Group>> groups;

  private int[] groupSizeByAge = new int[]{4,5,6,8,12,15};

  public GroupController(List<Student> students,List<Teacher> teachers){
    this.students = students;
    this.teachers = teachers;
     getList();
  }

  public void getGroupList() {

    List<Student>[] studentGroupByAge = getStudentGroupByAge(students);

    for(int i=0;i<studentGroupByAge.length;i++){
      if(studentGroupByAge[i].size()==0){
        continue;
      }
     List<Group> group = getGoupListByAge(studentGroupByAge[i],groupSizeByAge[i]);
      groups.put(i,group);
    }

    int teacherIndex = 0;

    for(List<Group> groupList:groups.values()){
      for(Group group:groupList){
        teacherIndex = teacherIndex%teachers.size();
        Teacher teacher = teachers.get(teacherIndex++);
        group.assignTeacher(teacher);
      }
    }

  }

  @Override
  public List<Group> getList() {
    return null;
  }

  @Override
  public void add(Group group) {

  }

  @Override
  public void update(Group group) {

  }

  @Override
  public Group detail(Group group) {
    return null;
  }

  @Override
  public Group query(Group group) {
    return null;
  }

  /**
   * 将学生按年龄段分类
   * @param students
   * @return
   */
  public List<Student>[] getStudentGroupByAge(List<Student> students){
    //age between 6-12
    List<Student> sixToTwelve = students.stream().filter(student -> student.getAge() >= 6 && student.getAge() <= 12).collect(
        Collectors.toList());

    //age between 13-24
    List<Student> thirteenToTwentyfour = students.stream().filter(student -> student.getAge() >= 13 && student.getAge() <= 24).collect(Collectors.toList());

    //age between 25-35
    List<Student> twentyfiveToThirtyFive = students.stream().filter(student -> student.getAge() >= 25 && student.getAge() <= 35).collect(Collectors.toList());

    //age between 36-47
    List<Student> thirtySixToFortySeven = students.stream().filter(student -> student.getAge() >= 36 && student.getAge() <= 47).collect(
        Collectors.toList());

    //age between 48-59
    List<Student> fortyEightToFiftyNine = students.stream().filter(student -> student.getAge() >= 48 && student.getAge() <= 59).collect(Collectors.toList());

    //age over 60
    List<Student> sixtyAndUp = students.stream().filter(student -> student.getAge() >= 60).collect(Collectors.toList());

   List<Student>[] studentAgeGroups = new ArrayList[6];

    studentAgeGroups[0] = sixToTwelve;
    studentAgeGroups[1] = thirteenToTwentyfour;
    studentAgeGroups[2]= twentyfiveToThirtyFive;
    studentAgeGroups[3]= thirtySixToFortySeven;
    studentAgeGroups[4] = fortyEightToFiftyNine;
    studentAgeGroups[5] = sixtyAndUp;

    return studentAgeGroups;
  }


  /**
   *
   * @param studs 待分配的学生列表
   * @param size  每个团体的学生人数限制
   */
  public List<Group>  getGoupListByAge(List<Student> studs, int size) {
    System.out.println("allocate GoupList By Age");
    System.out.println(studs);
    System.out.println(size);
    int numGroups = (studs.size()+size-1)/size;

    List<Group> groupsByAge = new ArrayList<>();
    int temp=0;
    for(int i = 0; i < numGroups; i++) {
      List<Student> students = studs.subList(temp,Math.min(temp+size,studs.size()));
      Group group =  new Group(null,students,size);
      temp = temp + size;
      groupsByAge.add(group);
    }
    return groupsByAge;
  }

}
