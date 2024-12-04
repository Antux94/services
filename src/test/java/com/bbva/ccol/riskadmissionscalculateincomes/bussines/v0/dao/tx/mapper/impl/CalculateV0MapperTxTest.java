package com.bbva.ccol.riskadmissionscalculateincomes.bussines.v0.dao.tx.mapper.impl;

import com.bbva.ccol.riskadmissionscalculateincomes.DummyMock;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.TransaccionCmlct001;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.in.RequestTransactionCmlct001_1;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.out.ResponseTransactionCmlct001_1;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.tx.mapper.impl.CalculateV0MapperTx;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dto.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;


public class CalculateV0MapperTxTest {

    @InjectMocks
    private CalculateV0MapperTx mapper;

    private DummyMock dummyMock;

    @Before
    public void setUp() throws  Exception{
        mapper = new CalculateV0MapperTx();
        MockitoAnnotations.initMocks(this);
        dummyMock = new DummyMock();
    }

    @Test
    public void mapInApxOperation(){
        BCalculate data = dummyMock.getBCalculateIn();
        RequestTransactionCmlct001_1 request = mapper.mapInApxData(data);
        Assert.assertNotNull(request);

        data.getPerson().setLaboralInformation(null);
        request = mapper.mapInApxData(data);
        Assert.assertNotNull(request);

        data.setPerson(null);
        data.setInformationSources(null);
        data.setProduct(null);
        request = mapper.mapInApxData(data);
        Assert.assertNotNull(request);

        try{
            RequestTransactionCmlct001_1 res = mapper.mapInApxData(null);
            Assert.assertNotNull(res);
        }catch (Exception e){

        }
    }

    @Test
    public void mapOutData(){
        ResponseTransactionCmlct001_1 data = dummyMock.getRespuestaTransaccionCmlct001();
        BData response = mapper.mapOutData(data);
        Assert.assertNotNull(response);

        data.getData().getPerson().setLaboralInformation(null);
        response = mapper.mapOutData(data);
        Assert.assertNotNull(response);

        data.getData().setPerson(null);
        data.getData().setEmployers(null);
        data.getData().setInformationSources(null);
        data.getData().setTotalIncomes(null);
        data.getData().setEmploymentHistory(null);
        data.getData().setStatus(null);
        data.getData().setTotalDeductions(null);
        response = mapper.mapOutData(data);
        Assert.assertNotNull(response);

        data.setData(null);
        response = mapper.mapOutData(data);
        Assert.assertNotNull(response);

        try{
            BData res = mapper.mapOutData(null);
            Assert.assertNotNull(res);
        }catch (Exception e){

        }
        Assert.assertNotNull(response);
    }

}

