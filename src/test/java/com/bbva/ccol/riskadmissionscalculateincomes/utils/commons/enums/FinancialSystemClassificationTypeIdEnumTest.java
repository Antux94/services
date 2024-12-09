package com.bbva.ccol.riskadmissionscreditevaluations.utils.commons.enums;

import org.junit.Test;

import static org.junit.Assert.assertNull;

public class FinancialSystemClassificationTypeIdEnumTest {

    @Test
    public void testGetByNameEmpty() {
        String name = "";
        String result = FinancialSystemClassificationTypeIdEnum.getByName(name);
        assertNull(result);
    }
}
