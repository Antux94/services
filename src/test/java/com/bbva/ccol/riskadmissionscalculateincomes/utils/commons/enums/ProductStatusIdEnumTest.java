package com.bbva.ccol.riskadmissionscreditevaluations.utils.commons.enums;

import org.junit.Test;

import static org.junit.Assert.assertNull;

public class ProductStatusIdEnumTest {
    @Test
    public void testGetByNameEmpty() {
        String name = "";
        String result = ProductStatusIdEnum.getByName(name);
        assertNull(result);
    }
}
