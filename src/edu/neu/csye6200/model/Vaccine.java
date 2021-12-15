package edu.neu.csye6200.model;

import edu.neu.csye6200.utils.DataTypeSwitchUtil;
import java.util.Date;

public class Vaccine implements Comparable<Vaccine>{
  String immunizationName;
  Date immuDate;
  Date Dose1Time;
  Date Dose2Time;
  Date Dose3Time;

  public Vaccine(String immunizationName, Date immuDate, int studentId) {
    this.immunizationName = immunizationName;
    this.immuDate = immuDate;
    this.studentId = studentId;
    this.Dose1Time=Dose1Time;
    this.Dose2Time=Dose2Time;
    this.Dose3Time=Dose3Time;
    
  }

    public Vaccine() {
         //To change body of generated methods, choose Tools | Templates.
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

    public Date getDose1Time() {
        return Dose1Time;
    }

    public void setDose1Time(Date Dose1Time) {
        this.Dose1Time = Dose1Time;
    }

    public Date getDose2Time() {
        return Dose2Time;
    }

    public void setDose2Time(Date Dose2Time) {
        this.Dose2Time = Dose2Time;
    }

    public Date getDose3Time() {
        return Dose3Time;
    }

    public void setDose3Time(Date Dose3Time) {
        this.Dose3Time = Dose3Time;
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
