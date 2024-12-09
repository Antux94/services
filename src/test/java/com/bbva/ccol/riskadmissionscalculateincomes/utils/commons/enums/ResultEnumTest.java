package com.bbva.ccol.riskadmissionscreditevaluations.utils.commons.enums;

import org.junit.Test;

import static org.junit.Assert.assertNull;

public class ResultEnumTest {
    @Test
    public void testGetByNameEmpty() {
        String name = "";
        String result = ResultEnum.getByName(name);
        assertNull(result);
    }
}
