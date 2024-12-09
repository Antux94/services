
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
    public void testMapInApxData() {
        RequestTransactionCmlct001_1 request = dummyMock.getRequestTransactionCmlct001_1();
        BBody response = mapper.mapInApxData(request);

        Assert.assertNotNull(response);

        // Person Assertions
        BPerson bPerson = response.getPerson();
        Assert.assertNotNull(bPerson);
        BIdentityDocument bIdentityDocument = bPerson.getIdentityDocument();
        Assert.assertNotNull(bIdentityDocument);
        Assert.assertEquals(request.getPerson().getIdentityDocument().getDocumentType(), bIdentityDocument.getDocumentType());
        Assert.assertEquals(request.getPerson().getIdentityDocument().getDocumentNumber(), bIdentityDocument.getDocumentNumber());
        Assert.assertEquals(request.getPerson().getFirstName(), bPerson.getFirstName());
        Assert.assertEquals(request.getPerson().getMiddleName(), bPerson.getMiddleName());
        Assert.assertEquals(request.getPerson().getLastName(), bPerson.getLastName());

        BLaboralInformation bLaboralInformation = bPerson.getLaboralInformation();
        Assert.assertNotNull(bLaboralInformation);
        Assert.assertEquals(request.getPerson().getLaboralInformation().getCompanyId(), bLaboralInformation.getCompanyId());
        Assert.assertEquals(Double.valueOf(request.getPerson().getLaboralInformation().getDeclaratedIncome()), bLaboralInformation.getDeclaratedIncome());


        // Information Sources Assertions
        List<BInformationSources> bInformationSourcesList = response.getInformationSources();
        Assert.assertNotNull(bInformationSourcesList);
        Assert.assertEquals(request.getInformationSources().size(), bInformationSourcesList.size());
        for (int i = 0; i < bInformationSourcesList.size(); i++) {
            BInformationSources bInformationSources = bInformationSourcesList.get(i);
            InformationSources informationSources = request.getInformationSources().get(i);
            Assert.assertEquals(informationSources.getId(), bInformationSources.getId());
            Assert.assertEquals(Boolean.valueOf(informationSources.getIsConsulted()), bInformationSources.getIsConsulted());
        }

        // Product Assertions
        BProduct bProduct = response.getProduct();
        Assert.assertNotNull(bProduct);
        Assert.assertEquals(request.getProduct().getId(), bProduct.getId());
        Assert.assertEquals(request.getProduct().getName(), bProduct.getName());
    }



    private class DummyMock {

        public RequestTransactionCmlct001_1 getRequestTransactionCmlct001_1() {
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
            laboralInformation.setDeclaratedIncome(5000000L); // Use Long type here
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

