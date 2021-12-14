package edu.neu.csye6200.controller;

import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.model.immunisations.AbstractImmunization;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ImmunizationContorller extends Controller<AbstractImmunization>{


  public void checkImmunization(Student s) {
//		Mailer m = new Mailer(s.getGuardianEmail());
//		if(immuDate.size() < 3 && s.getAge() >= 15) {
//			System.out.println(s.getAge());
//			m.setVaccine(this.immunizationName);
//			m.setDose("3");
//			m.setStudName(s.getFirstName() + " " + s.getLastName());
//			m.setRecpName(s.getGuardianName());
//			m.setPhoneNum(s.getPhoneNumber());
//			m.sendImmunizationNotificationMail();
//		} else if(immuDate.size() < 3 && s.getAge() >= 18) {
//			m.setVaccine(this.immunizationName);
//			m.setDose("3");
//			m.setStudName(s.getFirstName() + " " + s.getLastName());
//			m.setRecpName(s.getGuardianName());
//			m.setPhoneNum(s.getPhoneNumber());
//			m.sendImmunizationWarning();
//
//		}
  }

  public String printImmunization(Student s) {
    String immunizationName;
    List<Date> immuDate = new ArrayList<>();
    int age;

    if(immuDate.size() < 3 && s.getAge() >= 15) {
      return "Due: 3rd dose of Hepatitis B";
    } else if(immuDate.size() < 3 && s.getAge() >= 18) {
      return "Overdue: 3rd dose of Hepatitis B";
    }
    return "Hepatitis B vaccine up to date";
  }

  @Override
  public List<AbstractImmunization> getList() {
    return null;
  }

  @Override
  public void add(AbstractImmunization abstractImmunization) {

  }

  @Override
  public void update(AbstractImmunization abstractImmunization) {

  }

  @Override
  public AbstractImmunization detail(AbstractImmunization abstractImmunization) {
    return null;
  }

  @Override
  public AbstractImmunization query(AbstractImmunization abstractImmunization) {
    return null;
  }
}
