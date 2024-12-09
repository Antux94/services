package com.bbva.ccol.riskadmissionscreditevaluations.utils.commons.enums;

import org.junit.Test;

import static org.junit.Assert.assertNull;

public class DictumEnumTest {
    @Test
    public void testGetByNameEmpty() {
        String name = "";
        String result = DictumEnum.getByName(name);
        assertNull(result);
    }
}
