
package com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.tx.mapper;

import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.in.IdentityDocument;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.in.InformationSources;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.in.LaboralInformation;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.in.Person;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.in.Product;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.in.RequestTransactionCmlct001_1;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dto.BBody;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dto.BIdentityDocument;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dto.BInformationSources;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dto.BLaboralInformation;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dto.BPerson;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dto.BProduct;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.ArrayList;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class ICalculateV0MapperTxTest {

    private ICalculateV0MapperTx mapper = Mappers.getMapper(ICalculateV0MapperTx.class);
    private DummyMock dummyMock = new DummyMock();

    @Before
    public void setUp() {
        dummyMock = new DummyMock();
    }

    @Test
    public void testMapInData() {
        RequestTransactionCmlct001_1 source = dummyMock.buildRequestTransactionCmlct001_1();
        BBody target = mapper.mapInApxData(source);

        Assert.assertEquals(source.getPerson().getIdentityDocument().getDocumentType(), target.getPerson().getIdentityDocument().getDocumentType());
        Assert.assertEquals(source.getPerson().getIdentityDocument().getDocumentNumber(), target.getPerson().getIdentityDocument().getDocumentNumber());
        Assert.assertEquals(source.getPerson().getFirstName(), target.getPerson().getFirstName());
        Assert.assertEquals(source.getPerson().getMiddleName(), target.getPerson().getMiddleName());
        Assert.assertEquals(source.getPerson().getLastName(), target.getPerson().getLastName());
        Assert.assertEquals(source.getPerson().getLaboralInformation().getCompanyId(), target.getPerson().getLaboralInformation().getCompanyId());
        Assert.assertEquals(Double.valueOf(source.getPerson().getLaboralInformation().getDeclaratedIncome()), target.getPerson().getLaboralInformation().getDeclaratedIncome());

        for (int i = 0; i < source.getInformationSources().size(); i++) {
            Assert.assertEquals(source.getInformationSources().get(i).getId(), target.getInformationSources().get(i).getId());
            Assert.assertEquals(Boolean.valueOf(source.getInformationSources().get(i).getIsConsulted()), target.getInformationSources().get(i).getIsConsulted());
        }

        Assert.assertEquals(source.getProduct().getId(), target.getProduct().getId());
        Assert.assertEquals(source.getProduct().getName(), target.getProduct().getName());
    }
    
    @Test
    public void testMapInDataWithNulls() {
        RequestTransactionCmlct001_1 source = null;
        BBody target = mapper.mapInApxData(source);
        Assert.assertNull(target);


        source = new RequestTransactionCmlct001_1();
        target = mapper.mapInApxData(source);

        Assert.assertNotNull(target); // Target shouldn't be null even if source fields are

        source.setPerson(null);
        target = mapper.mapInApxData(source);
        Assert.assertNull(target.getPerson());

        Person person = new Person();
        source.setPerson(person);

        person.setIdentityDocument(null);
        target = mapper.mapInApxData(source);
        Assert.assertNull(target.getPerson().getIdentityDocument());

        person.setLaboralInformation(null);
        target = mapper.mapInApxData(source);
        Assert.assertNull(target.getPerson().getLaboralInformation());

        source.setInformationSources(null);
        target = mapper.mapInApxData(source);
        Assert.assertNull(target.getInformationSources());

        source.setProduct(null);
        target = mapper.mapInApxData(source);
        Assert.assertNull(target.getProduct());
    }



    private class DummyMock {

        public RequestTransactionCmlct001_1 buildRequestTransactionCmlct001_1() {
            RequestTransactionCmlct001_1 request = new RequestTransactionCmlct001_1();

            Person person = new Person();
            IdentityDocument identityDocument = new IdentityDocument();
            identityDocument.setDocumentType("CC");
            identityDocument.setDocumentNumber("1235489345");
            person.setIdentityDocument(identityDocument);
            person.setFirstName("Christian");
            person.setMiddleName("David");
            person.setLastName("Rojas");

            LaboralInformation laboralInformation = new LaboralInformation();
            laboralInformation.setCompanyId("800900231-5");
            laboralInformation.setDeclaratedIncome(5000000L);
            person.setLaboralInformation(laboralInformation);

            request.setPerson(person);

            List<InformationSources> informationSourcesList = new ArrayList<>();
            InformationSources informationSources = new InformationSources();
            informationSources.setId("SOI");
            informationSources.setIsConsulted("false");
            informationSourcesList.add(informationSources);
            request.setInformationSources(informationSourcesList);

            Product product = new Product();
            product.setId("12");
            product.setName("hipotecas");
            request.setProduct(product);

            return request;
        }
    }
}
