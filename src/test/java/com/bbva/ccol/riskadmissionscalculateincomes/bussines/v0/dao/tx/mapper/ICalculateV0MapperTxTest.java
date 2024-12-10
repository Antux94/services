
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

    private DummyMock dummyMock;

    @Before
    public void setUp() {
        dummyMock = new DummyMock();
    }

    @Test
    public void testMapInData() {
        RequestTransactionCmlct001_1 source = dummyMock.buildRequestTransactionCmlct001_1();
        BBody destination = mapper.mapInApxData(source);

        Assert.assertEquals(source.getPerson().getIdentityDocument().getDocumentType(), destination.getPerson().getIdentityDocument().getDocumentType());
        Assert.assertEquals(source.getPerson().getIdentityDocument().getDocumentNumber(), destination.getPerson().getIdentityDocument().getDocumentNumber());
        Assert.assertEquals(source.getPerson().getFirstName(), destination.getPerson().getFirstName());
        Assert.assertEquals(source.getPerson().getMiddleName(), destination.getPerson().getMiddleName());
        Assert.assertEquals(source.getPerson().getLastName(), destination.getPerson().getLastName());
        Assert.assertEquals(source.getPerson().getLaboralInformation().getCompanyId(), destination.getPerson().getLaboralInformation().getCompanyId());
        Assert.assertEquals(Double.valueOf(source.getPerson().getLaboralInformation().getDeclaratedIncome()), destination.getPerson().getLaboralInformation().getDeclaratedIncome());

        for (int i = 0; i < source.getInformationSources().size(); i++) {
            Assert.assertEquals(source.getInformationSources().get(i).getId(), destination.getInformationSources().get(i).getId());
            Assert.assertEquals(Boolean.valueOf(source.getInformationSources().get(i).getIsConsulted()), destination.getInformationSources().get(i).getIsConsulted());
        }

        Assert.assertEquals(source.getProduct().getId(), destination.getProduct().getId());
        Assert.assertEquals(source.getProduct().getName(), destination.getProduct().getName());
    }
    
    @Test
    public void testMapInDataWithNulls() {
        RequestTransactionCmlct001_1 source = null;
        BBody destination = mapper.mapInApxData(source);
        Assert.assertNull(destination);


        source = new RequestTransactionCmlct001_1();
        destination = mapper.mapInApxData(source);

        Assert.assertNotNull(destination); // Destination shouldn't be null even if source fields are

        source.setPerson(null);
        destination = mapper.mapInApxData(source);
        Assert.assertNull(destination.getPerson());

        source.setPerson(new Person());
        source.getPerson().setLaboralInformation(null);
        destination = mapper.mapInApxData(source);
        Assert.assertNull(destination.getPerson().getLaboralInformation());

        source.setInformationSources(null);
        destination = mapper.mapInApxData(source);
        Assert.assertNull(destination.getInformationSources());

        source.setProduct(null);
        destination = mapper.mapInApxData(source);
        Assert.assertNull(destination.getProduct());
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
