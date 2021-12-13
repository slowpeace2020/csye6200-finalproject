package edu.neu.csye6200.model.immunisations;

import java.util.Date;
import java.util.List;

public class HepatitisBFactory extends AbstractImmunizationFactory {

	private static HepatitisBFactory instance;
	private HepatitisBFactory() {
		instance = null;
	}
	public static HepatitisBFactory getInstance() {
		if(instance == null) {
			instance = new HepatitisBFactory();
		}
		
		return instance;
	}

	@Override
	public AbstractImmunization getObject(String name, List<Date> d, int age) {
		// TODO Auto-generated method stub
		return new HepatitisB(name, d, age);
	}

}
