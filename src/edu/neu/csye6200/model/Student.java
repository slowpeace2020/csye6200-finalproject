package edu.neu.csye6200.model;

import edu.neu.csye6200.model.immunisations.AbstractImmunization;
import edu.neu.csye6200.model.immunisations.DTaPFactory;
import edu.neu.csye6200.model.immunisations.HepatitisBFactory;
import edu.neu.csye6200.model.immunisations.PneumococcalConjugateFactory;
import edu.neu.csye6200.model.immunisations.RotavirusFactory;
import edu.neu.csye6200.utils.DataTypeSwitchUtil;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Student extends Person {
    private double gpa;
    private int studentID;
    private int age;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String guardianName;
    private String guardianEmail;
    private Date birthDay;
    private Date registrationDate;
    private List<AbstractImmunization> immunisations = new ArrayList<>();
    private Date annualRegistrationDate;


    public Student(){}

    public Student(int studentID) {
        this.studentID = studentID;
    }

    public Student(int age, String name, double gpa, int studentID) {
        super(age, name);
        this.gpa = gpa;
        this.studentID = studentID;
    }

    public Student(int age, String name) {
        super(age, name);
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(int gpa) {
        this.gpa = gpa;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public Student(String csvData) {
        super();
        String[] field = csvData.split(",");
        this.firstName = field[0];
        this.lastName = field[1];
        this.birthDay = DataTypeSwitchUtil.StringToDate(field[2]);
        this.studentID = DataTypeSwitchUtil.StringToInt(field[3]);
        this.registrationDate = DataTypeSwitchUtil.StringToDate(field[4]);
        this.address = field[5];
        this.phoneNumber = field[6];
        this.guardianName = field[7];
        this.guardianEmail = field[8];
        this.age = DataTypeSwitchUtil.DateToAge(this.birthDay);
        Calendar c = Calendar.getInstance();
        c.setTime(this.registrationDate);
        c.add(c.YEAR, 1);
        this.annualRegistrationDate = c.getTime();

        int flag = 0;
        List<Date> hepatitisB = new ArrayList<>();
        List<Date> DTaP = new ArrayList<>();
        List<Date> rotavirus = new ArrayList<>();
        List<Date> pneumococcalConjugate = new ArrayList<>();
        for(int i = 9; i < 23; i++) {
            System.out.println(field[i]);
            if(field[i].contentEquals("0")) {

            }
            else {
                if(i >= 9 && i < 12) {
                    hepatitisB.add(DataTypeSwitchUtil.StringToDate(field[i]));
                }
                if(i >= 12 && i < 16) {
                    DTaP.add(DataTypeSwitchUtil.StringToDate(field[i]));
                }
                if(i >= 16 && i < 19) {
                    rotavirus.add(DataTypeSwitchUtil.StringToDate(field[i]));
                }
                if(i >= 19 && i < 23) {
                    pneumococcalConjugate.add(DataTypeSwitchUtil.StringToDate(field[i]));
                }
            }

        }

        immunisations.add(DTaPFactory.getInstance().getObject("DTaP",DTaP,this.age));
        immunisations.add(RotavirusFactory.getInstance().getObject("Rotavirus", rotavirus, this.age));
        immunisations.add(HepatitisBFactory.getInstance().getObject("Hepatitis B",hepatitisB, this.age));
        immunisations.add(PneumococcalConjugateFactory.getInstance().getObject("Pneumococcal Conjugate",pneumococcalConjugate, this.age));

    }

}
