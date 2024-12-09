package com.bbva.ccol.riskadmissionscreditevaluations.utils.commons.enums;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class SegmentDelegationEnumTest {
    @Test
    public void testGetName() {
        SegmentDelegationEnum segmentDelegationEnum = SegmentDelegationEnum.PYMES;
        String result = segmentDelegationEnum.getName();
        assertEquals("PYMES", result);
    }
    @Test
    public void testGetByName() {
        String name = "PYMES";
        String result = SegmentDelegationEnum.getByName(name);
        assertEquals("PYMES", result);
    }
    @Test
    public void testGetByNameNull() {
        String name = null;
        String result = SegmentDelegationEnum.getByName(name);
        assertNull(result);
    }
    @Test
    public void testGetByNameEmpty() {
        String name = "";
        String result = SegmentDelegationEnum.getByName(name);
        assertNull(result);
    }
}
