package edu.neu.csye6200.model.immunisations;

import java.util.Date;
import java.util.List;

public abstract class AbstractImmunizationFactory {
	
	public abstract AbstractImmunization getObject(String name, List<Date> d, int age);

}
