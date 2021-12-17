package edu.neu.csye6200.controller;

import edu.neu.csye6200.utils.MailUtil;
import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.model.Vaccine;
import edu.neu.csye6200.utils.DataTypeSwitchUtil;
import edu.neu.csye6200.utils.FileUtil;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImmunizationContorller extends Controller<Vaccine>{

  private static String defaultFilePath =System.getProperty("user.dir")+"/data/immunization.csv";
  private Map<Integer,List<Vaccine>> immuMap;
  private List<Vaccine> immuList;
  private Map<String,Integer> requiredVaccineMap = new HashMap<>();

  public ImmunizationContorller() {
    this(defaultFilePath);
  }

  private List<Student> alertList = new ArrayList<>();

  public ImmunizationContorller(String filePath) {
    requiredVaccineMap.put("DTaP",3);
    requiredVaccineMap.put("Rotavirus",3);
    requiredVaccineMap.put("Hepatitis B",3);
    requiredVaccineMap.put("Pneumococcal Conjugate",3);
    immuMap = new HashMap<>();
    immuList = new ArrayList<>();
    List<String> tempImmus = FileUtil.readTextFile(filePath);
    for(String record:tempImmus){
      String[] strings= record.split(",");
      String immuName = strings[0];
      int studentId = Integer.parseInt(strings[1]);
      Date date = DataTypeSwitchUtil.StringToDate(strings[2]);
     List<Vaccine> vaccines = immuMap.getOrDefault(studentId,new ArrayList<>());
     Vaccine cur = new Vaccine(immuName,date,studentId);
     vaccines.add(cur);
     immuList.add(cur);
     immuMap.put(studentId,vaccines);
    }


  }


  public void getImmunizationInfo(List<Student> students) {
    students.stream().forEach(student -> getImmunizationInfo(student));
  }


  public void getImmunizationInfo(Student s) {
    List<Vaccine> list = immuMap.get(s.getStudentID());

    if(list==null){
      return;
    }
    s.setVaccines(list);
    Collections.sort(list);
    Map<String,List<Date>> vaccineMap = new HashMap<>();
    for(Vaccine vaccine:list){
      List<Date> curList = vaccineMap.getOrDefault(vaccine.getImmunizationName(),new ArrayList<>());
      curList.add(vaccine.getImmuDate());
      vaccineMap.put(vaccine.getImmunizationName(),curList);
   }

    StringBuilder immuInfo =new StringBuilder();

    for(String item : requiredVaccineMap.keySet()){
        if(!vaccineMap.containsKey(item)){
          immuInfo.append("Please get the first"+ item +" shot as soon as possible.\n");
        }else{
          List<Date> dateList = vaccineMap.get(item);
          int index = dateList.size();
          Date lastDate = dateList.get(index-1);

          if(index==requiredVaccineMap.get(item)){
            continue;
          }else{
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(lastDate);
            if(index==1){
              calendar.add(Calendar.MONTH,1);
            }else if(index==2){
              calendar.add(Calendar.MONTH,6);
            }

            Date today = new Date();
            Calendar standard = Calendar.getInstance();
            standard.setTime(today);
            if(standard.compareTo(calendar)>=0){

              immuInfo.append("Please get the");

              String dorse = index==1? "second":"third";
              immuInfo.append(dorse);
              immuInfo.append(" shot as soon as possible.\n");
            }

          }
        }
    }

    s.setImmuDetail(immuInfo.toString());

  }

  @Override
  public List<Vaccine> getList() {
    return immuList;
  }

  @Override
  public void add(Vaccine vaccine) {
      Date[] dates= new Date[3];
    dates[0] = vaccine.getDose1Time();
    dates[1] = vaccine.getDose2Time();
    dates[2] = vaccine.getDose3Time();
    for(Date date:dates){
      if(date==null){
        continue;
      }

      Vaccine addVaccine = new Vaccine();
      addVaccine.setImmunizationName(vaccine.getImmunizationName());
      addVaccine.setStudentId(vaccine.getStudentId());
      addVaccine.setImmuDate(date);
      FileUtil.writeTextFile(defaultFilePath,addVaccine.toString());
    }

  }

  @Override
  public void update(Vaccine vaccine) {

  }

  @Override
  public Vaccine detail(Vaccine vaccine) {
    return null;
  }

  @Override
  public Vaccine query(Vaccine vaccine) {
    return null;
  }

  public List<Student> getAlert() {
    StudentController sc = new StudentController();
    sc.getList().forEach(s->{
      if ( s.getImmuDetail()==null || s.getImmuDetail().isEmpty())
        alertList.add(s);
    });
    return alertList;
  }

  private Thread t = null;

  public void alert() {
    if (t!=null) {
      t.interrupt();
    }
    getAlert();
    System.out.println(alertList.size());
    t = new Thread(new Runnable() {
      @Override
      public void run() {
        alertList.forEach(s->{
          StringBuilder sb = new StringBuilder();
          sb.append("hello, ").append(s.getFirstName()).append("\n\n");
          sb.append("According to our record, you are not fully vaccine").append("\n\n");
          sb.append("Best\n");
          MailUtil.getInstance().sendMail(((Student) s).getGuardianEmail(), "Vaccine Reminder", sb.toString());
        });
      }
    });
    System.out.println(1);
    t.start();
  }

  public static void main(String[] args) {
    ImmunizationContorller ic = new ImmunizationContorller();
    ic.alert();
  }
}
