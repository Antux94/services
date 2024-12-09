package com.bbva.ccol.riskadmissionscreditevaluations.utils.commons.enums;

import org.junit.Test;

import static org.junit.Assert.assertNull;

public class CardTypeIdEnumTest {
    @Test
    public void testGetByNameEmpty() {
        String name = "";
        String result = CardTypeIdEnum.getByName(name);
        assertNull(result);
    }
}
