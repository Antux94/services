
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
    public void mapInApxDataTest() {

        RequestTransactionCmlct001_1 requestTransactionCmlct001_1 = dummyMock.getRequestTransactionCmlct001_1();
        BBody bBody = mapper.mapInApxData(requestTransactionCmlct001_1);

        Assert.assertEquals(requestTransactionCmlct001_1.getPerson().getIdentityDocument().getDocumentType(), bBody.getPerson().getIdentityDocument().getDocumentType());
        Assert.assertEquals(requestTransactionCmlct001_1.getPerson().getIdentityDocument().getDocumentNumber(), bBody.getPerson().getIdentityDocument().getDocumentNumber());
        Assert.assertEquals(requestTransactionCmlct001_1.getPerson().getFirstName(), bBody.getPerson().getFirstName());
        Assert.assertEquals(requestTransactionCmlct001_1.getPerson().getMiddleName(), bBody.getPerson().getMiddleName());
        Assert.assertEquals(requestTransactionCmlct001_1.getPerson().getLastName(), bBody.getPerson().getLastName());
        Assert.assertEquals(requestTransactionCmlct001_1.getPerson().getLaboralInformation().getCompanyId(), bBody.getPerson().getLaboralInformation().getCompanyId());
        Assert.assertEquals(Double.valueOf(requestTransactionCmlct001_1.getPerson().getLaboralInformation().getDeclaratedIncome()), Double.valueOf(bBody.getPerson().getLaboralInformation().getDeclaratedIncome()));

        for (int i = 0; i < requestTransactionCmlct001_1.getInformationSources().size(); i++) {
            Assert.assertEquals(requestTransactionCmlct001_1.getInformationSources().get(i).getId(), bBody.getInformationSources().get(i).getId());
            Assert.assertEquals(Boolean.valueOf(requestTransactionCmlct001_1.getInformationSources().get(i).getIsConsulted()), bBody.getInformationSources().get(i).getIsConsulted());
        }

        Assert.assertEquals(requestTransactionCmlct001_1.getProduct().getId(), bBody.getProduct().getId());
        Assert.assertEquals(requestTransactionCmlct001_1.getProduct().getName(), bBody.getProduct().getName());

    }


    class DummyMock {

        private RequestTransactionCmlct001_1 requestTransactionCmlct001_1;


        public void init() {

            requestTransactionCmlct001_1 = new RequestTransactionCmlct001_1();

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
            laboralInformation.setDeclaratedIncome(Long.valueOf(1000));
            person.setLaboralInformation(laboralInformation);
            requestTransactionCmlct001_1.setPerson(person);

            List<InformationSources> informationSourcesList = new ArrayList<>();
            InformationSources informationSources = new InformationSources();
            informationSources.setId("1");
            informationSources.setIsConsulted("true");
            informationSourcesList.add(informationSources);
            requestTransactionCmlct001_1.setInformationSources(informationSourcesList);

            Product product = new Product();
            product.setId("456");
            product.setName("Product Name");
            requestTransactionCmlct001_1.setProduct(product);

        }

        public RequestTransactionCmlct001_1 getRequestTransactionCmlct001_1() {
            return requestTransactionCmlct001_1;
        }

    }
}
