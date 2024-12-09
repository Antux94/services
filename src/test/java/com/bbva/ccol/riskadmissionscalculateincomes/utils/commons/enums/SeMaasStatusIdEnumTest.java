package com.bbva.ccol.riskadmissionscreditevaluations.utils.commons.enums;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class SeMaasStatusIdEnumTest {
    @Test
    public void testGetName() {
        SeMaasStatusIdEnum seMaasStatusIdEnum = SeMaasStatusIdEnum.FINISHED;
        String result = seMaasStatusIdEnum.getName();
        assertEquals("FINISHED", result);
    }
    @Test
    public void testGetByName() {
        String name = "FINISHED";
        String result = SeMaasStatusIdEnum.getByName(name);
        assertEquals("FINISHED", result);
    }
    @Test
    public void testGetByNameNull() {
        String name = null;
        String result = SeMaasStatusIdEnum.getByName(name);
        assertNull(result);
    }
    @Test
    public void testGetByNameEmpty() {
        String name = "";
        String result = SeMaasStatusIdEnum.getByName(name);
        assertNull(result);
    }
}
