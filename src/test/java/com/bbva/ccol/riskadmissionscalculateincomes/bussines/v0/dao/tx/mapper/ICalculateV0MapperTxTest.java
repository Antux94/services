
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
        dummyMock.init();
    }

    @Test
    public void mapInApxDataTest() {

        RequestTransactionCmlct001_1 requestTransactionCmlct001_1 = dummyMock.getRequestTransactionCmlct001_1();
        BBody bBody = mapper.mapInApxData(requestTransactionCmlct001_1);

        //Assertions
        Assert.assertNotNull(bBody);

        //Person Assertions
        BPerson bPerson = bBody.getPerson();
        Assert.assertNotNull(bPerson);
        Assert.assertEquals(requestTransactionCmlct001_1.getPerson().getFirstName(), bPerson.getFirstName());
        Assert.assertEquals(requestTransactionCmlct001_1.getPerson().getMiddleName(), bPerson.getMiddleName());
        Assert.assertEquals(requestTransactionCmlct001_1.getPerson().getLastName(), bPerson.getLastName());

        //IdentityDocument Assertions
        BIdentityDocument bIdentityDocument = bPerson.getIdentityDocument();
        Assert.assertNotNull(bIdentityDocument);
        Assert.assertEquals(requestTransactionCmlct001_1.getPerson().getIdentityDocument().getDocumentType(), bIdentityDocument.getDocumentType());
        Assert.assertEquals(requestTransactionCmlct001_1.getPerson().getIdentityDocument().getDocumentNumber(), bIdentityDocument.getDocumentNumber());

        //LaboralInformation Assertions
        BLaboralInformation bLaboralInformation = bPerson.getLaboralInformation();
        Assert.assertNotNull(bLaboralInformation);
        Assert.assertEquals(requestTransactionCmlct001_1.getPerson().getLaboralInformation().getCompanyId(), bLaboralInformation.getCompanyId());
        Assert.assertEquals(requestTransactionCmlct001_1.getPerson().getLaboralInformation().getDeclaratedIncome().doubleValue(), bLaboralInformation.getDeclaratedIncome(), 0);


        //InformationSources Assertions
        List<BInformationSources> bInformationSourcesList = bBody.getInformationSources();
        Assert.assertNotNull(bInformationSourcesList);
        Assert.assertEquals(requestTransactionCmlct001_1.getInformationSources().size(), bInformationSourcesList.size());
        for (int i = 0; i < bInformationSourcesList.size(); i++) {
            Assert.assertEquals(requestTransactionCmlct001_1.getInformationSources().get(i).getId(), bInformationSourcesList.get(i).getId());
            Assert.assertEquals(Boolean.valueOf(requestTransactionCmlct001_1.getInformationSources().get(i).getIsConsulted()), bInformationSourcesList.get(i).getIsConsulted());
        }

        //Product Assertions
        BProduct bProduct = bBody.getProduct();
        Assert.assertNotNull(bProduct);
        Assert.assertEquals(requestTransactionCmlct001_1.getProduct().getId(), bProduct.getId());
        Assert.assertEquals(requestTransactionCmlct001_1.getProduct().getName(), bProduct.getName());

    }


    class DummyMock {

        private RequestTransactionCmlct001_1 requestTransactionCmlct001_1;


        public void init() {

            requestTransactionCmlct001_1 = new RequestTransactionCmlct001_1();

            Person person = new Person();
            person.setFirstName("John");
            person.setMiddleName("Doe");
            person.setLastName("Smith");

            IdentityDocument identityDocument = new IdentityDocument();
            identityDocument.setDocumentType("Passport");
            identityDocument.setDocumentNumber("123456789");
            person.setIdentityDocument(identityDocument);

            LaboralInformation laboralInformation = new LaboralInformation();
            laboralInformation.setCompanyId("ACME Corp");
            laboralInformation.setDeclaratedIncome(100000L); // Use Long type
            person.setLaboralInformation(laboralInformation);

            requestTransactionCmlct001_1.setPerson(person);

            List<InformationSources> informationSourcesList = new ArrayList<>();
            InformationSources informationSources = new InformationSources();
            informationSources.setId("1");
            informationSources.setIsConsulted("true");
            informationSourcesList.add(informationSources);

            informationSources = new InformationSources();
            informationSources.setId("2");
            informationSources.setIsConsulted("false");
            informationSourcesList.add(informationSources);
            requestTransactionCmlct001_1.setInformationSources(informationSourcesList);


            Product product = new Product();
            product.setId("prod-123");
            product.setName("Product Name");
            requestTransactionCmlct001_1.setProduct(product);

        }

        public RequestTransactionCmlct001_1 getRequestTransactionCmlct001_1() {
            return requestTransactionCmlct001_1;
        }

    }
}
