package edu.neu.csye6200.controller;

import edu.neu.csye6200.controller.Util.FileUtil;
import edu.neu.csye6200.model.Immunization;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ImmunizationController {

    private final List<Immunization> immunizationsList = new ArrayList<>();

    private static final String CSVTitles = "id,name,doses,information";

    private static final ImmunizationController instance = new ImmunizationController();

    private static final String dir = "./src/main/resources/";

    private ImmunizationController() {
        createImmunizations(dir + "immunization.csv");
    }

    public static ImmunizationController getInstance() {
        return instance;
    }

    public List<Immunization> getImmunizationsList() {
        return immunizationsList;
    }

    private void createImmunizations(String CSVFilename) {
        List<String> CSVList = FileUtil.read(CSVFilename);
        // skip title line
        for (int i = 1; i < CSVList.size(); i++) {
            Immunization immunization = getImmunization(CSVList.get(i));
            if (immunization!=null)
                addImmunization(immunization);
            else
                throw new NullPointerException("null object");
        }
    }

    public void addImmunization(Immunization immunization) {
        immunizationsList.add(immunization);
    }

    public Immunization getImmunization(String CSVString) {
        String name;
        int id, doses;
        String information;
        Immunization immunization = null;
        Scanner in = new Scanner(CSVString);
        in.useDelimiter(",");
        try {
            id = in.nextInt();
            name = in.next();
            doses = in.nextInt();
            information = in.next();
            immunization = new Immunization(id, name, doses, information);
        } catch (Exception e) {
            e.printStackTrace();
        }
        in.close();

        return immunization;
    }
}
