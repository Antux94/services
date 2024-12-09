package com.bbva.ccol.riskadmissionscreditevaluations.utils.commons;

import com.bbva.ccol.riskadmissionscreditevaluations.utils.commons.enums.ScaleValuePropertiesEnum;
import com.bbva.ccol.riskadmissionscreditevaluations.utils.commons.enums.SeMaasStatusIdEnum;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CallSequenceMessageEnumTest {

    @Test
    public void testGetMessage() {
        CallSequenceMessageEnum callSequenceMessageEnum = CallSequenceMessageEnum.FACADE_STEP_REQUEST;
        String result = callSequenceMessageEnum.getMessage();
        assertEquals("1", result);
    }
}
