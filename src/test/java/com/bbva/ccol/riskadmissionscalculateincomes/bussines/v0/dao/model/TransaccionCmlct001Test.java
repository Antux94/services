package com.bbva.ccol.riskadmissionscalculateincomes.bussines.v0.dao.model;

import com.bbva.ccol.riskadmissionscalculateincomes.DummyMock;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.TransaccionCmlct001;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.out.ResponseTransactionCmlct001_1;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


public class TransaccionCmlct001Test {
    @InjectMocks
    TransaccionCmlct001 transaccionCmlct001;

    @Mock
    private ServicioTransacciones servicioTransacciones;

    private DummyMock dummyMock = new DummyMock();

    private static final String POJO_PACKAGE = "com.bbva.ccol.riskadmissionscalculateincomes.bussines.v0.dao.model";

    @Before
    public void setUp(){
        transaccionCmlct001 = new TransaccionCmlct001();
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void Cmlct001(){
        Mockito.when(servicioTransacciones.invocar(Matchers.any(),Matchers.any(),Matchers.any())).thenReturn(new ResponseTransactionCmlct001_1());
            Assert.assertNotNull(dummyMock.getTransaccionCmlct001());
            Assert.assertNotNull(transaccionCmlct001.invocar(dummyMock.getTransaccionCmlct001()));
            Assert.assertNotNull(transaccionCmlct001.invocarCache(dummyMock.getTransaccionCmlct001()));
            transaccionCmlct001.vaciarCache();
    }


}
