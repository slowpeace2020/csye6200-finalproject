package edu.neu.csye6200.model;

import edu.neu.csye6200.utils.DataTypeSwitchUtil;
import java.util.Calendar;
import java.util.Date;

public class Teacher extends Person {
    private int credits;
    private int teacherID;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public Date getAnnualReviewDate() {
        return annualReviewDate;
    }

    public void setAnnualReviewDate(Date annualReviewDate) {
        this.annualReviewDate = annualReviewDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String firstName;
    private String lastName;
    private Date birthDay;
    private Date joiningDate;
    private Date annualReviewDate;
    private String email;

    public Teacher(){}

    public Teacher(int teacherID) {
        this.teacherID = teacherID;
    }

    public Teacher(int age, String name, int credits, int teacherID) {
        super(age, name);
        this.credits = credits;
        this.teacherID = teacherID;
    }

    public Teacher(int age, String name) {
        super(age, name);
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public Teacher(String csvData) {
        super();
        String[] field = csvData.split(",");
        this.firstName  = field[0];
        this.lastName  = field[1];
        this.birthDay = DataTypeSwitchUtil.StringToDate(field[2]);
        this.teacherID = DataTypeSwitchUtil.StringToInt(field[3]);
        this.joiningDate = DataTypeSwitchUtil.StringToDate(field[4]);
        this.annualReviewDate = DataTypeSwitchUtil.StringToDate(field[4]);
        this.email = field[5];
        this.credits = Integer.parseInt(field[5]);
        Calendar c = Calendar.getInstance();
//        c.setTime(this.joiningDate);
        //c.add(c.WEEK_OF_YEAR, 51);
        c.add(c.YEAR, 1);
        this.annualReviewDate = c.getTime();
    }

    @Override
    public String toString() {
        return "Teacher{" +
            "credits=" + credits +
            ", teacherID=" + teacherID +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", birthDay=" + birthDay +
            ", joiningDate=" + joiningDate +
            ", annualReviewDate=" + annualReviewDate +
            ", email='" + email + '\'' +
            '}';
    }

    public String csvLine() {
        return firstName + '\'' +
            "," + lastName + '\'' +
            "," + birthDay +
            "," + annualReviewDate +
            ",'" + email + '\'' +
            ",'" + credits + '\'';
    }
}

