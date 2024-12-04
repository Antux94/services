package com.bbva.ccol.riskadmissionscalculateincomes.facade.v0.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpMethod;

public class ServiceResponseAcceptedNoBodyTest {


    @Test
    public void objectTest(){
       ServiceResponseAcceptedNoBody response = ServiceResponseAcceptedNoBody.ServiceResponseAcceptedNoBodyBuilder.build();
        Assert.assertNotNull(response.getHttpStatus(HttpMethod.POST));
    }
}
