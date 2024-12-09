package com.bbva.ccol.riskadmissionscreditevaluations.utils.commons.enums;

import org.junit.Test;

import static org.junit.Assert.assertNull;

public class RoleTypeIdEnumTest {
    @Test
    public void testGetByNameEmpty() {
        String name = "";
        String result = RoleTypeIdEnum.getByName(name);
        assertNull(result);
    }
}
