package com.bbva.ccol.riskadmissionscalculateincomes.facade.v0.impl;

import com.bbva.ccol.riskadmissionscalculateincomes.DummyMock;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.IBSrvRiskAdmissionsCalculateIncomesv0;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dto.BCalculate;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dto.BData;
import com.bbva.ccol.riskadmissionscalculateincomes.facade.v0.dto.Calculate;
import com.bbva.ccol.riskadmissionscalculateincomes.facade.v0.dto.Data;
import com.bbva.ccol.riskadmissionscalculateincomes.facade.v0.mapper.ICalculateMapper;
import com.bbva.ccol.riskadmissionscalculateincomes.facade.v0.mapper.IDataMapper;
import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponseInterface;
import com.bbva.jee.arq.spring.core.managers.OutputHeaderManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class SrvRiskAdmissionsCalculateIncomesv0Test {

    @InjectMocks
    private SrvRiskAdmissionsCalculateIncomesv0 srvRiskAdmissionsCalculateIncomesv0;

    @Mock
    private IBSrvRiskAdmissionsCalculateIncomesv0 ibSrvRiskAdmissionsCalculateIncomesv0;

    @Mock
    private ICalculateMapper iCalculateMapper;

    @Mock
    private IDataMapper iDataMapper;


    @Mock
    private OutputHeaderManager outputHeaderManager;


    private DummyMock dummyMock;

    @Before
    public void init(){
        dummyMock = new DummyMock();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void postIdentificationDataPersonTest(){
        Calculate calculate = dummyMock.getCalculate();
        BCalculate bCalculate = dummyMock.getBCalculateIn();
        Data data = dummyMock.getData(calculate);
        BData bData = dummyMock.getBDataOut(bCalculate);
        Mockito.when(iCalculateMapper.mapInCalculate(calculate)).thenReturn(bCalculate);
        Mockito.when(ibSrvRiskAdmissionsCalculateIncomesv0.postCalculateIncomes(bCalculate)).thenReturn(bData);
        Mockito.when(iDataMapper.mapOutData(bData)).thenReturn(data);
        ServiceResponseInterface response = srvRiskAdmissionsCalculateIncomesv0.postIdentificationDataPerson(calculate);
        Assert.assertNotNull(response);
    }

    @Test
    public void postIdentificationDataPerson1Test(){
        Calculate calculate = dummyMock.getCalculate1();
        BCalculate bCalculate = dummyMock.getBCalculateIn();
        Data data = dummyMock.getData(calculate);
        BData bData = dummyMock.getBDataOut(bCalculate);
        Mockito.when(iCalculateMapper.mapInCalculate(calculate)).thenReturn(bCalculate);
        Mockito.when(ibSrvRiskAdmissionsCalculateIncomesv0.postCalculateIncomes(bCalculate)).thenReturn(bData);
        Mockito.when(iDataMapper.mapOutData(bData)).thenReturn(data);
        ServiceResponseInterface response = srvRiskAdmissionsCalculateIncomesv0.postIdentificationDataPerson(calculate);
        Assert.assertNotNull(response);
    }

    @Test
    public void postIdentificationDataPerson2Test(){
        Calculate calculate = dummyMock.getCalculate1();
        BCalculate bCalculate = dummyMock.getBCalculateIn();
        Data data = dummyMock.getData(calculate);
        BData bData = dummyMock.getBDataOut(bCalculate);
        bData.setPerson(null);
        Mockito.when(iCalculateMapper.mapInCalculate(calculate)).thenReturn(bCalculate);
        Mockito.when(ibSrvRiskAdmissionsCalculateIncomesv0.postCalculateIncomes(bCalculate)).thenReturn(bData);
        Mockito.when(iDataMapper.mapOutData(bData)).thenReturn(data);
        ServiceResponseInterface response = srvRiskAdmissionsCalculateIncomesv0.postIdentificationDataPerson(calculate);
        Assert.assertNotNull(response);
    }
}
