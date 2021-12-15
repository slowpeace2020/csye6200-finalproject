package edu.neu.csye6200.view;

import edu.neu.csye6200.controller.ImmunizationContorller;
import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.model.Vaccine;
import edu.neu.csye6200.utils.DataTypeSwitchUtil;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class Test {

  public static void main(String[] args) {

    ImmunizationContorller contorller = new ImmunizationContorller();
    List<Vaccine> immuMap = contorller.getList();
    System.out.println(immuMap);
    for(Vaccine s : immuMap) {

      String[] row = new String[5];
      row[0] = String.valueOf(s.getStudentId());
      row[1] = s.getImmunizationName();
      row[2] = DataTypeSwitchUtil.DateToString(s.getImmuDate());
      System.out.println(row[2]);
    }
  }

}
