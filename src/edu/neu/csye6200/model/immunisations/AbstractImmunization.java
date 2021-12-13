package edu.neu.csye6200.model.immunisations;

import edu.neu.csye6200.model.Student;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class AbstractImmunization {

	String immunizationName;
	List<Date> immuDate = new ArrayList<>();
	int age;
	public abstract void checkImmunization(Student s);
	public abstract String printImmunization(Student s);
}
