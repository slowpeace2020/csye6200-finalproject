package edu.neu.csye6200.model;

import edu.neu.csye6200.utils.DataTypeSwitchUtil;
import java.util.Date;

public class Vaccine implements Comparable<Vaccine>{
  String immunizationName;
  Date immuDate;

  public Vaccine(String immunizationName, Date immuDate, int studentId) {
    this.immunizationName = immunizationName;
    this.immuDate = immuDate;
    this.studentId = studentId;
  }

  public String getImmunizationName() {
    return immunizationName;
  }

  public void setImmunizationName(String immunizationName) {
    this.immunizationName = immunizationName;
  }

  public Date getImmuDate() {
    return immuDate;
  }

  public void setImmuDate(Date immuDate) {
    this.immuDate = immuDate;
  }

  public int getStudentId() {
    return studentId;
  }

  public void setStudentId(int studentId) {
    this.studentId = studentId;
  }

  int studentId;

  @Override
  public int compareTo(Vaccine o) {
    if(this.immunizationName.compareTo(o.immunizationName)==0){
      return this.immuDate.compareTo(o.immuDate);
    }
    return this.immunizationName.compareTo(o.immunizationName);
  }

  @Override
  public String toString() {
    return  immunizationName + "," + studentId+ "," + DataTypeSwitchUtil.DateToString(immuDate) ;
  }
}
