package com.bbva.ccol.riskadmissionscreditevaluations.utils.commons.enums;

import org.junit.Test;

import static org.junit.Assert.assertNull;

public class ScoringTypeIdEnumTest {
    @Test
    public void testGetByNameEmpty() {
        String name = "";
        String result = ScoringTypeIdEnum.getByName(name);
        assertNull(result);
    }
}
