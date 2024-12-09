
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
    public void setUp() throws Exception {

    }

    @Test
    public void mapInApxData() {
        RequestTransactionCmlct001_1 requestTransactionCmlct001_1 = dummyMock.getRequestTransactionCmlct001_1();
        BBody bBody = mapper.mapInApxData(requestTransactionCmlct001_1);

        //Assertions for Person
        Assert.assertEquals(requestTransactionCmlct001_1.getPerson().getIdentityDocument().getDocumentType(), bBody.getPerson().getIdentityDocument().getDocumentType());
        Assert.assertEquals(requestTransactionCmlct001_1.getPerson().getIdentityDocument().getDocumentNumber(), bBody.getPerson().getIdentityDocument().getDocumentNumber());
        Assert.assertEquals(requestTransactionCmlct001_1.getPerson().getFirstName(), bBody.getPerson().getFirstName());
        Assert.assertEquals(requestTransactionCmlct001_1.getPerson().getMiddleName(), bBody.getPerson().getMiddleName());
        Assert.assertEquals(requestTransactionCmlct001_1.getPerson().getLastName(), bBody.getPerson().getLastName());
        Assert.assertEquals(requestTransactionCmlct001_1.getPerson().getLaboralInformation().getCompanyId(), bBody.getPerson().getLaboralInformation().getCompanyId());
        Assert.assertEquals(requestTransactionCmlct001_1.getPerson().getLaboralInformation().getDeclaratedIncome().doubleValue(), bBody.getPerson().getLaboralInformation().getDeclaratedIncome());

        //Assertions for InformationSources
        List<InformationSources> informationSourcesList = requestTransactionCmlct001_1.getInformationSources();
        List<BInformationSources> bInformationSourcesList = bBody.getInformationSources();

        for (int i = 0; i < informationSourcesList.size(); i++) {
            Assert.assertEquals(informationSourcesList.get(i).getId(), bInformationSourcesList.get(i).getId());
            Assert.assertEquals(Boolean.parseBoolean(informationSourcesList.get(i).getIsConsulted()), bInformationSourcesList.get(i).getIsConsulted());
        }

        //Assertions for Product
        Assert.assertEquals(requestTransactionCmlct001_1.getProduct().getId(), bBody.getProduct().getId());
        Assert.assertEquals(requestTransactionCmlct001_1.getProduct().getName(), bBody.getProduct().getName());

    }


    class DummyMock {

        public RequestTransactionCmlct001_1 getRequestTransactionCmlct001_1() {
            RequestTransactionCmlct001_1 request = new RequestTransactionCmlct001_1();

            Person person = new Person();
            IdentityDocument identityDocument = new IdentityDocument();
            identityDocument.setDocumentType("CC");
            identityDocument.setDocumentNumber("12345");
            person.setIdentityDocument(identityDocument);
            person.setFirstName("John");
            person.setMiddleName("David");
            person.setLastName("Doe");

            LaboralInformation laboralInformation = new LaboralInformation();
            laboralInformation.setCompanyId("123");
            laboralInformation.setDeclaratedIncome(Long.valueOf(1000.00)); // Using Long.valueOf for conversion
            person.setLaboralInformation(laboralInformation);
            request.setPerson(person);


            List<InformationSources> informationSources = new ArrayList<>();
            InformationSources infoSource1 = new InformationSources();
            infoSource1.setId("1");
            infoSource1.setIsConsulted("true");
            informationSources.add(infoSource1);

            InformationSources infoSource2 = new InformationSources();
            infoSource2.setId("2");
            infoSource2.setIsConsulted("false");
            informationSources.add(infoSource2);

            request.setInformationSources(informationSources);

            Product product = new Product();
            product.setId("456");
            product.setName("Product Name");
            request.setProduct(product);

            return request;
        }
    }
}
