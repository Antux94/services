package com.bbva.ccol.riskadmissionscreditevaluations.utils.commons.enums;

import org.junit.Test;

import static org.junit.Assert.assertNull;

public class EvaluationTypeIdEnumTest {

    @Test
    public void testGetByNameEmpty() {
        String name = "";
        String result = EvaluationTypeIdEnum.getByName(name);
        assertNull(result);
    }
}
