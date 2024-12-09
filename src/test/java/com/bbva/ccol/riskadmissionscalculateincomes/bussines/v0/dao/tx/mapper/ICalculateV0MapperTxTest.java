
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

import java.util.List;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
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
    public void mapInApxDataTest() {

        RequestTransactionCmlct001_1 request = dummyMock.getRequestTransactionCmlct001_1();
        BBody response = mapper.mapInApxData(request);

        //BBody Assertions
        Assert.assertNotNull(response);

        //BPerson Assertions
        Assert.assertNotNull(response.getPerson());
        Assert.assertEquals(request.getPerson().getFirstName(), response.getPerson().getFirstName());
        Assert.assertEquals(request.getPerson().getMiddleName(), response.getPerson().getMiddleName());
        Assert.assertEquals(request.getPerson().getLastName(), response.getPerson().getLastName());

        //BIdentityDocument Assertions
        Assert.assertNotNull(response.getPerson().getIdentityDocument());
        Assert.assertEquals(request.getPerson().getIdentityDocument().getDocumentType(), response.getPerson().getIdentityDocument().getDocumentType());
        Assert.assertEquals(request.getPerson().getIdentityDocument().getDocumentNumber(), response.getPerson().getIdentityDocument().getDocumentNumber());

        //BLaboralInformation Assertions
        Assert.assertNotNull(response.getPerson().getLaboralInformation());
        Assert.assertEquals(request.getPerson().getLaboralInformation().getCompanyId(), response.getPerson().getLaboralInformation().getCompanyId());
        Assert.assertEquals(request.getPerson().getLaboralInformation().getDeclaratedIncome().doubleValue(), response.getPerson().getLaboralInformation().getDeclaratedIncome(), 0.0);


        //BInformationSources Assertions
        Assert.assertNotNull(response.getInformationSources());
        for (int i = 0; i < response.getInformationSources().size(); i++) {
            Assert.assertEquals(request.getInformationSources().get(i).getId(), response.getInformationSources().get(i).getId());
            Assert.assertEquals(Boolean.valueOf(request.getInformationSources().get(i).getIsConsulted()), response.getInformationSources().get(i).getIsConsulted());
        }

        //BProduct Assertions
        Assert.assertNotNull(response.getProduct());
        Assert.assertEquals(request.getProduct().getId(), response.getProduct().getId());
        Assert.assertEquals(request.getProduct().getName(), response.getProduct().getName());

    }

    class DummyMock {

        public RequestTransactionCmlct001_1 getRequestTransactionCmlct001_1() {
            RequestTransactionCmlct001_1 request = new RequestTransactionCmlct001_1();
            Person person = new Person();
            IdentityDocument identityDocument = new IdentityDocument();
            LaboralInformation laboralInformation = new LaboralInformation();
            List<InformationSources> informationSources = new ArrayList<>();
            Product product = new Product();

            identityDocument.setDocumentType("CC");
            identityDocument.setDocumentNumber("123456789");
            person.setIdentityDocument(identityDocument);

            person.setFirstName("John");
            person.setMiddleName("David");
            person.setLastName("Doe");

            laboralInformation.setCompanyId("123");
            laboralInformation.setDeclaratedIncome(Long.valueOf(10000)); // Using Long.valueOf
            person.setLaboralInformation(laboralInformation);

            request.setPerson(person);

            InformationSources infoSource1 = new InformationSources();
            infoSource1.setId("1");
            infoSource1.setIsConsulted("true");
            informationSources.add(infoSource1);

            InformationSources infoSource2 = new InformationSources();
            infoSource2.setId("2");
            infoSource2.setIsConsulted("false");
            informationSources.add(infoSource2);

            request.setInformationSources(informationSources);

            product.setId("456");
            product.setName("Product Name");

            request.setProduct(product);

            return request;
        }
    }
}
