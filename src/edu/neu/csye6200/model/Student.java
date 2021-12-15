package edu.neu.csye6200.model;

//import edu.neu.csye6200.model.immunisations.AbstractImmunization;
//import edu.neu.csye6200.model.immunisations.DTaPFactory;
//import edu.neu.csye6200.model.immunisations.HepatitisBFactory;
//import edu.neu.csye6200.model.immunisations.PneumococcalConjugateFactory;
//import edu.neu.csye6200.model.immunisations.RotavirusFactory;
import edu.neu.csye6200.utils.DataTypeSwitchUtil;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Student extends Person {
    private double gpa;
    private int studentID;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String guardianName;
    private String guardianEmail;
    private Date birthDay;
    private Date registrationDate;

    public List<Vaccine> getVaccines() {
        return vaccines;
    }

    public void setVaccines(List<Vaccine> vaccines) {
        this.vaccines = vaccines;
    }

    private List<Vaccine> vaccines = new ArrayList<>();
    private Date annualRegistrationDate;

    private String immuDetail;


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

    public String getImmuDetail() {
        return immuDetail;
    }

    public String getGuardianEmail() {
        return guardianEmail;
    }

    public void setImmuDetail(String immuDetail) {
        this.immuDetail = immuDetail;
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
        this.gpa = Double.parseDouble(field[9]);
        setAge(DataTypeSwitchUtil.DateToAge(this.birthDay));
        Calendar c = Calendar.getInstance();
        c.setTime(this.registrationDate);
        c.add(c.YEAR, 1);
        this.annualRegistrationDate = c.getTime();


    }

    @Override
    public String toString() {
        return "Student{" +
            "gpa=" + gpa +
            ", studentID=" + studentID +
            ", age=" + getAge() +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", address='" + address + '\'' +
            ", phoneNumber='" + phoneNumber + '\'' +
            ", guardianName='" + guardianName + '\'' +
            ", guardianEmail='" + guardianEmail + '\'' +
            ", birthDay=" + birthDay +
            ", registrationDate=" + registrationDate +
//            ", immunisations=" + immunisations +
            ", annualRegistrationDate=" + annualRegistrationDate +
            '}';
    }

    public String csvLine(){
        return "Student{" +
            "gpa=" + gpa +
            ", studentID=" + studentID +
            ", age=" + getAge() +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", address='" + address + '\'' +
            ", phoneNumber='" + phoneNumber + '\'' +
            ", guardianName='" + guardianName + '\'' +
            ", guardianEmail='" + guardianEmail + '\'' +
            ", birthDay=" + birthDay +
            ", registrationDate=" + registrationDate +
//            ", immunisations=" + immunisations +
            ", annualRegistrationDate=" + annualRegistrationDate;
    }
}
