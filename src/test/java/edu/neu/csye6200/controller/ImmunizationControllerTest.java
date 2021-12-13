package edu.neu.csye6200.controller;

import edu.neu.csye6200.model.Immunization;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ImmunizationControllerTest {

    private static final ImmunizationController instance = ImmunizationController.getInstance();

    private static final String dir = "./src/test/resources/";

    @Test
    void getInstance() {
        assertNotEquals(null, instance);
    }

    @Test
    void getImmunizationsList() {
        List<Immunization> immunizationsList = instance.getImmunizationsList();
        assertNotEquals(null, immunizationsList.get(0));
    }
}