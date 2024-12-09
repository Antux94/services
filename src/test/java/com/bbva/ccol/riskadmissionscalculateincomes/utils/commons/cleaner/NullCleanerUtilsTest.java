package com.bbva.ccol.riskadmissionscreditevaluations.utils.commons.cleaner;


import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class NullCleanerUtilsTest {

    @Test
    public void testCleanNullObject() {
        Object nullObject = null;
        Object result = NullCleanerUtils.clean(nullObject);
        assertNull(result);
    }

    @Test
    public void testCleanNonNullObject() {
        // Create an object with no null fields
        Value nonNullObject = new Value();
        nonNullObject.setAmountApx(123);
        nonNullObject.setCurrencyApx("test");
        Value result = (Value) NullCleanerUtils.clean(nonNullObject);
        assertNotNull(result);
        assertEquals(123, result.getAmountApx());
        assertEquals("test", result.getCurrencyApx());

    }

    @Test
    public void testCleanObjectWithNullFields() {
        Value objectWithNullFields = new Value();
        objectWithNullFields.setAmountApx(123);
        objectWithNullFields.setCurrencyApx(null);
        Value result = (Value) NullCleanerUtils.clean(objectWithNullFields);
        assertNull(result.getCurrencyApx());
        assertEquals(123, result.getAmountApx());
    }


    @Test
    public void testCleanCollectionWithAllNullElements() {
        Collection<String> collection = Arrays.asList(null, null, null, null);
        Collection<String> cleaned = NullCleanerUtils.clean(collection);
        assertNull(cleaned);
    }


    //prubassss
    @Test
    public void testCleanWithNullObject() {
        Object nullObject = null;
        Object result = NullCleanerUtils.clean(nullObject);
        assertNull(result);
    }

    @Test
    public void testCleanWithNonNullPrimitiveType() {
        String nonNullString = "Test";
        String result = NullCleanerUtils.clean(nonNullString);
        assertEquals(null, result);
    }


    @Test
    public void testCleanWithNullCollection() {
        Collection<String> collection = Arrays.asList(null, null, null, null);
        Collection<String> result = NullCleanerUtils.clean(collection);
        assertNull(result);
    }

    @Test
    public void testCleanWithNonNullCleanableType() {
        Value workplaces = new Value();
        workplaces.setCurrencyApx("Test");
        workplaces.setAmountApx(10);
        Value result = NullCleanerUtils.clean(workplaces);
        assertEquals("Test", result.getCurrencyApx());
        assertEquals(10, result.getAmountApx());
    }

    @Test
    public void testCleanWithNullCleanableType() {
        Value workplaces = new Value();
        workplaces.setCurrencyApx(null);
        workplaces.setAmountApx(null);
        Value result = NullCleanerUtils.clean(workplaces);
        assertNull(result);
    }
}
