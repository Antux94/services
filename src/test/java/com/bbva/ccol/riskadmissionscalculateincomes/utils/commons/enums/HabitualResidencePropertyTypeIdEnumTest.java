package com.bbva.ccol.riskadmissionscreditevaluations.utils.commons.enums;

import org.junit.Test;

import static org.junit.Assert.assertNull;

public class HabitualResidencePropertyTypeIdEnumTest {
    @Test
    public void testGetByNameEmpty() {
        String name = "";
        String result = HabitualResidencePropertyTypeIdEnum.getByName(name);
        assertNull(result);
    }
}
