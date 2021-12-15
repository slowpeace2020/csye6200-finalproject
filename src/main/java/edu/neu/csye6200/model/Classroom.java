package edu.neu.csye6200.model;

import java.util.*;

public class Classroom {

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public int getId() {
        return id;
    }

    private List<Group> groups;
    private int size;


    public void setId(int id) {
        this.id = id;
    }

    private int id;


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Classroom(List<Group> groups, int size) {
        this.groups = groups;
        this.size = size;
    }

    public List<Group> getGroups() {
        return this.groups;
    }

    @Override
    public String toString() {
        String temp="";
        for(int i=0;i<groups.size();i++) {
            temp = temp + " " +  groups.get(i).getTeacher().getFirstName();
        }
        return temp;
    }

}
