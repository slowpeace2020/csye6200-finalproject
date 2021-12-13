package edu.neu.csye6200.controller;

import edu.neu.csye6200.model.Classroom;
import edu.neu.csye6200.model.Group;
import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.model.Teacher;
import edu.neu.csye6200.utils.FileUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.stream.Collectors;

public class ClassRoomController extends Controller<Classroom>{

  public List<Classroom> getClassRoomList() {
    return classRoomList;
  }


  private List<Classroom> classRoomList;
  private Map<Integer,List<Group>> groups;

  private int[] classSizeByAge = new int[]{3,3,3,3,2,2};


  public ClassRoomController(Map<Integer,List<Group>> groups) {
    this.groups = groups;
    classRoomList = new ArrayList<>();
    getList();
  }


  @Override
  public List<Classroom> getList() {

    for(Integer groupId:groups.keySet()){
      List<Group> groupList = groups.get(groupId);
      int classSize = classSizeByAge[groupId];
      getClassroomList(groupList,classSize);
    }

    return classRoomList;
  }

  @Override
  public void add(Classroom classRoom) {

  }

  @Override
  public void update(Classroom classroom) {

  }


  @Override
  public Classroom detail(Classroom classRoom) {
    return null;
  }

  @Override
  public Classroom query(Classroom classRoom) {
    return null;
  }



  public void getClassroomList(List<Group> groupList, int size) {
    int temp = 0;
    int numClassrooms = (groupList.size()+size-1)/size;
    System.out.println("number of classrooms");
    System.out.println(groups.size());
    System.out.println(numClassrooms);
    for(int i = 0; i<numClassrooms; i++) {
      List<Group> subGroups = groupList.subList(temp,Math.min(temp+size,groupList.size()));
      Classroom classroom =  new Classroom(subGroups,size);
      temp = temp + size;
      classRoomList.add(classroom);
    }
  }
}
