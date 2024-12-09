package com.bbva.ccol.riskadmissionscreditevaluations.utils.commons;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LogUtilsTest {

    @Test
    public void testBuildLogMessageWithFilter() {
        String result = LogUtils.buildLogMessage(CallSequenceMessageEnum.FACADE_STEP_REQUEST, "filterValue");
        assertEquals("1, filter=filterValue", result);
    }

    @Test
    public void testBuildLogMessageWithObject() {
        Object testObject = new Object() {
            @Override
            public String toString() {
                return "TestObject";
            }
        };
        String result = LogUtils.buildLogMessage(CallSequenceMessageEnum.FACADE_STEP_REQUEST, testObject);
        assertEquals("1, TestObject", result);
    }

    @Test
    public void testBuildLogMessageWithAttributeAndObject() {
        Object testObject = new Object() {
            @Override
            public String toString() {
                return "TestObject";
            }
        };
        String result = LogUtils.buildLogMessage(CallSequenceMessageEnum.FACADE_STEP_REQUEST, "attributeValue", testObject);
        assertEquals("1, , attributeValue, TestObject", result);
    }

    @Test
    public void testBuildLogMessageWithNullAttributeAndObject() {
        Object testObject = new Object() {
            @Override
            public String toString() {
                return "TestObject";
            }
        };
        String result = LogUtils.buildLogMessage(CallSequenceMessageEnum.FACADE_STEP_REQUEST, null, testObject);
        assertEquals("1, , , TestObject", result);
    }

}

