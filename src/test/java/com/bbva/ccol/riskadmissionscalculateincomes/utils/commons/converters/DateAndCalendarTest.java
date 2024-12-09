package com.bbva.ccol.riskadmissionscreditevaluations.utils.commons.converters;

import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import org.junit.Test;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class DateAndCalendarTest {

    @Test
    public void testToCalendar() {
        Date date = new Date();
        Calendar result = DateAndCalendar.toCalendar(date);
        assertNotNull(result);
        assertEquals(date.getTime(), result.getTimeInMillis());
    }
    @Test
    public void testToCalendarDateNull() {
        Date date = null;
        Calendar result = DateAndCalendar.toCalendar(date);
        assertNull(result);
    }
    @Test
    public void testToDateCalendarNull() {
        Calendar calendar = null;
        Date result = DateAndCalendar.toDate(calendar);
        assertNull(result);
    }
    @Test
    public void testToDateNull() {
        String date = null;
        Date result = DateAndCalendar.toDate(date);
        assertNull(result);
    }
    @Test
    public void testToDateException() {
        String date = "invalid date";
        Date result = DateAndCalendar.toDate(date);
        assertNull(result);
    }
}
