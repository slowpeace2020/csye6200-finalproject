package edu.neu.csye6200.model;

public class Immunization {
    private final int id;
    private final String name;
    private final int doses;
    private final String information;

    public Immunization(int id, String name, int doses, String information) {
        this.id = id;
        this.name = name;
        this.doses = doses;
        this.information = information;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDoses() {
        return doses;
    }

    public String getInformation() {
        return information;
    }

    @Override
    public String toString() {
        return "Immunization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", doses=" + doses +
                ", information='" + information + '\'' +
                '}';
    }

    public static void main(String[] args) {
        System.out.println(1);
    }
}
