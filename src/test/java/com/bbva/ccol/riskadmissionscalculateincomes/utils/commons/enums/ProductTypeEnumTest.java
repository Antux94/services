package com.bbva.ccol.riskadmissionscreditevaluations.utils.commons.enums;

import org.junit.Test;

import static org.junit.Assert.assertNull;

public class ProductTypeEnumTest {

    @Test
    public void testGetByNameEmpty() {
        String name = "";
        String result = ProductTypeEnum.getByName(name);
        assertNull(result);
    }
}
