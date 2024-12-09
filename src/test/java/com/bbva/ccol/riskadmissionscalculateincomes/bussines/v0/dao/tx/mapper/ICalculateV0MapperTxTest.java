
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
    public void testMapInApxData() {
        RequestTransactionCmlct001_1 request = dummyMock.buildRequestTransactionCmlct001_1();
        BBody response = mapper.mapInApxData(request);

        Assert.assertNotNull(response);

        // Person Assertions
        BPerson bPerson = response.getPerson();
        Person person = request.getPerson();
        Assert.assertNotNull(bPerson);
        Assert.assertEquals(person.getFirstName(), bPerson.getFirstName());
        Assert.assertEquals(person.getMiddleName(), bPerson.getMiddleName());
        Assert.assertEquals(person.getLastName(), bPerson.getLastName());

        // IdentityDocument Assertions
        BIdentityDocument bIdentityDocument = bPerson.getIdentityDocument();
        IdentityDocument identityDocument = person.getIdentityDocument();
        Assert.assertNotNull(bIdentityDocument);
        Assert.assertEquals(identityDocument.getDocumentType(), bIdentityDocument.getDocumentType());
        Assert.assertEquals(identityDocument.getDocumentNumber(), bIdentityDocument.getDocumentNumber());

        // LaboralInformation Assertions
        BLaboralInformation bLaboralInformation = bPerson.getLaboralInformation();
        LaboralInformation laboralInformation = person.getLaboralInformation();
        Assert.assertNotNull(bLaboralInformation);
        Assert.assertEquals(laboralInformation.getCompanyId(), bLaboralInformation.getCompanyId());
        Assert.assertEquals(Double.valueOf(String.valueOf(laboralInformation.getDeclaratedIncome())), bLaboralInformation.getDeclaratedIncome());


        // InformationSources Assertions
        List<BInformationSources> bInformationSourcesList = response.getInformationSources();
        List<InformationSources> informationSourcesList = request.getInformationSources();
        Assert.assertNotNull(bInformationSourcesList);
        Assert.assertEquals(informationSourcesList.size(), bInformationSourcesList.size());
        for (int i = 0; i < informationSourcesList.size(); i++) {
            Assert.assertEquals(informationSourcesList.get(i).getId(), bInformationSourcesList.get(i).getId());
            Assert.assertEquals(Boolean.valueOf(informationSourcesList.get(i).getIsConsulted()), bInformationSourcesList.get(i).getIsConsulted());
        }

        // Product Assertions
        BProduct bProduct = response.getProduct();
        Product product = request.getProduct();
        Assert.assertNotNull(bProduct);
        Assert.assertEquals(product.getId(), bProduct.getId());
        Assert.assertEquals(product.getName(), bProduct.getName());
    }


    class DummyMock {

        public RequestTransactionCmlct001_1 buildRequestTransactionCmlct001_1() {
            RequestTransactionCmlct001_1 request = new RequestTransactionCmlct001_1();
            Person person = new Person();
            person.setFirstName("John");
            person.setMiddleName("David");
            person.setLastName("Doe");

            IdentityDocument identityDocument = new IdentityDocument();
            identityDocument.setDocumentType("Passport");
            identityDocument.setDocumentNumber("123456789");
            person.setIdentityDocument(identityDocument);

            LaboralInformation laboralInformation = new LaboralInformation();
            laboralInformation.setCompanyId("ACME Corp");
            laboralInformation.setDeclaratedIncome(Long.valueOf("100000"));
            person.setLaboralInformation(laboralInformation);
            request.setPerson(person);


            List<InformationSources> informationSourcesList = new ArrayList<>();
            InformationSources informationSources = new InformationSources();
            informationSources.setId("source1");
            informationSources.setIsConsulted("true");
            informationSourcesList.add(informationSources);
            request.setInformationSources(informationSourcesList);

            Product product = new Product();
            product.setId("product1");
            product.setName("Loan");
            request.setProduct(product);

            return request;
        }
    }
}

