package com.bbva.ccol.riskadmissionscreditevaluations.utils.commons.enums;

import org.junit.Test;

import static org.junit.Assert.assertNull;

public class AddressTypeIdEnumTest {

    @Test
    public void testGetByNameEmpty() {
        String name = "";
        String result = AddressTypeIdEnum.getByName(name);
        assertNull(result);
    }
}
