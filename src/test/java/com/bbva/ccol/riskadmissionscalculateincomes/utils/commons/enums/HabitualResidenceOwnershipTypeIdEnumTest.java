package com.bbva.ccol.riskadmissionscreditevaluations.utils.commons.enums;

import org.junit.Test;

import static org.junit.Assert.assertNull;

public class HabitualResidenceOwnershipTypeIdEnumTest {

    @Test
    public void testGetByNameEmpty() {
        String name = "";
        String result = HabitualResidenceOwnershipTypeIdEnum.getByName(name);
        assertNull(result);
    }
}
