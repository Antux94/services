
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
        dummyMock.init();
    }

    @Test
    public void testMapInApxData() {
        RequestTransactionCmlct001_1 source = dummyMock.getRequestTransactionCmlct001_1();
        BBody destination = mapper.mapInApxData(source);

        Assert.assertNotNull(destination);
        // Person Assertions
        Assert.assertEquals(source.getPerson().getIdentityDocument().getDocumentType(), destination.getPerson().getIdentityDocument().getDocumentType());
        Assert.assertEquals(source.getPerson().getIdentityDocument().getDocumentNumber(), destination.getPerson().getIdentityDocument().getDocumentNumber());
        Assert.assertEquals(source.getPerson().getFirstName(), destination.getPerson().getFirstName());
        Assert.assertEquals(source.getPerson().getMiddleName(), destination.getPerson().getMiddleName());
        Assert.assertEquals(source.getPerson().getLastName(), destination.getPerson().getLastName());
        Assert.assertEquals(source.getPerson().getLaboralInformation().getCompanyId(), destination.getPerson().getLaboralInformation().getCompanyId());
        Assert.assertEquals(Double.valueOf(String.valueOf(source.getPerson().getLaboralInformation().getDeclaratedIncome())), Double.valueOf(String.valueOf(destination.getPerson().getLaboralInformation().getDeclaratedIncome())));


        // Information Sources Assertions
        Assert.assertEquals(source.getInformationSources().size(), destination.getInformationSources().size());
        for (int i = 0; i < source.getInformationSources().size(); i++) {
            Assert.assertEquals(source.getInformationSources().get(i).getId(), destination.getInformationSources().get(i).getId());
            Assert.assertEquals(Boolean.valueOf(source.getInformationSources().get(i).getIsConsulted()), destination.getInformationSources().get(i).getIsConsulted());
        }

        // Product Assertions
        Assert.assertEquals(source.getProduct().getId(), destination.getProduct().getId());
        Assert.assertEquals(source.getProduct().getName(), destination.getProduct().getName());
    }


    class DummyMock {
        private RequestTransactionCmlct001_1 requestTransactionCmlct001_1;


        public void init() {
            requestTransactionCmlct001_1 = new RequestTransactionCmlct001_1();

            Person person = new Person();
            IdentityDocument identityDocument = new IdentityDocument();
            identityDocument.setDocumentType("CC");
            identityDocument.setDocumentNumber("123456789");
            person.setIdentityDocument(identityDocument);
            person.setFirstName("John");
            person.setMiddleName("David");
            person.setLastName("Doe");

            LaboralInformation laboralInformation = new LaboralInformation();
            laboralInformation.setCompanyId("BBVA");
            laboralInformation.setDeclaratedIncome(Long.valueOf(1000)); // Conversion to Long
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
            product.setId("123");
            product.setName("Product Name");

            requestTransactionCmlct001_1.setProduct(product);

        }

        public RequestTransactionCmlct001_1 getRequestTransactionCmlct001_1() {
            return requestTransactionCmlct001_1;
        }

    }
}
