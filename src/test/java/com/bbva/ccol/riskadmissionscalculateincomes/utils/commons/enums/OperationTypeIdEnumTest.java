package com.bbva.ccol.riskadmissionscreditevaluations.utils.commons.enums;

import org.junit.Test;

import static org.junit.Assert.assertNull;

public class OperationTypeIdEnumTest {
    @Test
    public void testGetByNameEmpty() {
        String name = "";
        String result = OperationTypeIdEnum.getByName(name);
        assertNull(result);
    }
}
