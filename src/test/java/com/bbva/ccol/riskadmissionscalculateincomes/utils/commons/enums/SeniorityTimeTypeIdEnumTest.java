package com.bbva.ccol.riskadmissionscreditevaluations.utils.commons.enums;

import org.junit.Test;

import static org.junit.Assert.assertNull;

public class SeniorityTimeTypeIdEnumTest {

    @Test
    public void testGetByNameEmpty() {
        String name = "";
        String result = SeniorityTimeTypeIdEnum.getByName(name);
        assertNull(result);
    }
}
