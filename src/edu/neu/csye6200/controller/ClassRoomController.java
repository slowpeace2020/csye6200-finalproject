package edu.neu.csye6200.controller;

import edu.neu.csye6200.model.ClassRoom;
import edu.neu.csye6200.model.Group;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClassRoomController extends Controller<ClassRoom>{

  public List<ClassRoom> getList() {
    return classRoomList;
  }


  private List<ClassRoom> classRoomList;
  private Map<Integer,List<Group>> groups;

  private int[] classSizeByAge = new int[]{3,3,3,3,2,2};


  public ClassRoomController(Map<Integer,List<Group>> groups) {
    this.groups = groups;
    classRoomList = new ArrayList<>();
    getClassRoomList();
  }


  public List<ClassRoom> getClassRoomList() {

    for(Integer groupId:groups.keySet()){
      List<Group> groupList = groups.get(groupId);
      int classSize = classSizeByAge[groupId];
      getClassroomList(groupList,classSize);
    }

    return classRoomList;
  }

  @Override
  public void add(ClassRoom classRoom) {

  }

  @Override
  public void update(ClassRoom classroom) {

  }


  @Override
  public ClassRoom detail(ClassRoom classRoom) {
    return null;
  }

  @Override
  public ClassRoom query(ClassRoom classRoom) {
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
      ClassRoom classroom =  new ClassRoom(subGroups,size);
      classroom.setId(i+1);
      temp = temp + size;
      classRoomList.add(classroom);
    }
  }
}
