package com.bbva.ccol.riskadmissionscreditevaluations.utils.commons;

import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import java.util.Date;
import static org.junit.Assert.assertNotNull;

public class DateAdapterTest {

    @InjectMocks
    private DateAdapter dateAdapter;

    @Before
    public void init(){
        dateAdapter = new DateAdapter();
    }

    @Test
    public void testMarshal() {
        Date date = new Date();
        String result = dateAdapter.marshal(date);
        assertNotNull(result);
    }

    @Test
    public void testUnmarshal() {
        String date = "2022-12-31T23:59:59.999+0000";
        Date result = dateAdapter.unmarshal(date);
        assertNotNull(result);
    }

    @Test(expected = BusinessServiceException.class)
    public void testUnmarshalException() {
        String date = "invalid date";
        dateAdapter.unmarshal(date);
    }


}
