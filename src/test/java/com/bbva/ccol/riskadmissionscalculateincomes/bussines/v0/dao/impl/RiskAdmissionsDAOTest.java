package com.bbva.ccol.riskadmissionscalculateincomes.bussines.v0.dao.impl;

import com.bbva.ccol.riskadmissionscalculateincomes.DummyMock;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.impl.RiskAdmissionsCalculateIncomesDAOImpl;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.TransaccionCmlct001;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.in.RequestTransactionCmlct001_1;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.tx.mapper.ICalculateV0MapperTx;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dto.BCalculate;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

public class RiskAdmissionsDAOTest {

    @InjectMocks
    RiskAdmissionsCalculateIncomesDAOImpl riskAdmissionsDAO;

    @Mock
    ICalculateV0MapperTx calculateV0MapperTx;

    @Mock
    TransaccionCmlct001 transaccionCmlct001;


    private DummyMock dummyMock;

    @Before
    public void init(){
        dummyMock = new DummyMock();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void postCreateDataTest(){
        BCalculate bCalculate = dummyMock.getBCalculateIn();


        Mockito.when(calculateV0MapperTx.mapInApxData(ArgumentMatchers.any(BCalculate.class)))
                .thenReturn(dummyMock.getTransaccionCmlct001());


        Mockito.when(transaccionCmlct001.invocar(ArgumentMatchers.any(RequestTransactionCmlct001_1.class)))

                .thenReturn(dummyMock.getRespuestaTransaccionCmlct001());

        riskAdmissionsDAO.createData(bCalculate);
    }

}
