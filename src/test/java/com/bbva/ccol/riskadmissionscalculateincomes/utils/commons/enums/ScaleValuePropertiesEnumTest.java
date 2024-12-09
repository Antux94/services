package com.bbva.ccol.riskadmissionscreditevaluations.utils.commons.enums;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ScaleValuePropertiesEnumTest {
    @Test
    public void testGetName() {
        ScaleValuePropertiesEnum scaleValuePropertiesEnum = ScaleValuePropertiesEnum.LOW;
        String result = scaleValuePropertiesEnum.getName();
        assertEquals("LOW", result);
    }
    @Test
    public void testGetByName() {
        String name = "LOW";
        String result = ScaleValuePropertiesEnum.getByName(name);
        assertEquals("LOW", result);
    }
    @Test
    public void testGetByNameNull() {
        String name = null;
        String result = ScaleValuePropertiesEnum.getByName(name);
        assertNull(result);
    }
    @Test
    public void testGetByNameEmpty() {
        String name = "";
        String result = ScaleValuePropertiesEnum.getByName(name);
        assertNull(result);
    }
}
