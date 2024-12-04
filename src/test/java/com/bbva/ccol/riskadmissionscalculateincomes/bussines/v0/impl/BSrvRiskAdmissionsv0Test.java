package com.bbva.ccol.riskadmissionscalculateincomes.bussines.v0.impl;

import com.bbva.ccol.riskadmissionscalculateincomes.DummyMock;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.IRiskAdmissionsCalculateIncomesDAO;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dto.BCalculate;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dto.BData;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.impl.BSrvRiskAdmissionsCalculateIncomesv0;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class BSrvRiskAdmissionsv0Test {
    @InjectMocks
    private BSrvRiskAdmissionsCalculateIncomesv0 srvRiskAdmissionsv0;

    @Mock
    private IRiskAdmissionsCalculateIncomesDAO iRiskAdmissionsDAO;

    private DummyMock dummyMock;

    @Before
    public void init(){
        dummyMock = new DummyMock();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void postCalculateIncomesTest(){
        BCalculate bCalculateIn = dummyMock.getBCalculateIn();
        BData bDataOut = dummyMock.getBDataOut(bCalculateIn);
        Mockito.when(iRiskAdmissionsDAO.createData(bCalculateIn)).thenReturn(bDataOut);
        srvRiskAdmissionsv0.postCalculateIncomes(bCalculateIn);
    }

}
