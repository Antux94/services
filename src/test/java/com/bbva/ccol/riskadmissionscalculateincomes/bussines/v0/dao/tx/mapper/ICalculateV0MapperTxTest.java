
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

    }


    @Test
    public void mapInApxDataTest() {
        BBody bBody = dummyMock.getBBody();
        RequestTransactionCmlct001_1 requestTransactionCmlct001_1 = mapper.mapInApxData(bBody);

        //Assertions for RequestTransactionCmlct001_1
        Assert.assertNotNull(requestTransactionCmlct001_1);

        //Assertions for Person
        Person person = requestTransactionCmlct001_1.getPerson();
        Assert.assertNotNull(person);
        Assert.assertEquals(bBody.getPerson().getIdentityDocument().getDocumentType(), person.getIdentityDocument().getDocumentType());
        Assert.assertEquals(bBody.getPerson().getIdentityDocument().getDocumentNumber(), person.getIdentityDocument().getDocumentNumber());
        Assert.assertEquals(bBody.getPerson().getFirstName(), person.getFirstName());
        Assert.assertEquals(bBody.getPerson().getMiddleName(), person.getMiddleName());
        Assert.assertEquals(bBody.getPerson().getLastName(), person.getLastName());
        Assert.assertEquals(bBody.getPerson().getLaboralInformation().getCompanyId(), person.getLaboralInformation().getCompanyId());
        Assert.assertEquals(bBody.getPerson().getLaboralInformation().getDeclaratedIncome().longValue(), person.getLaboralInformation().getDeclaratedIncome());


        //Assertions for InformationSources List
        List<BInformationSources> bInformationSourcesList = bBody.getInformationSources();
        List<InformationSources> informationSourcesList = requestTransactionCmlct001_1.getInformationSources();

        Assert.assertNotNull(informationSourcesList);
        Assert.assertEquals(bInformationSourcesList.size(), informationSourcesList.size());

        for (int i = 0; i < bInformationSourcesList.size(); i++) {
            Assert.assertEquals(bInformationSourcesList.get(i).getId(), informationSourcesList.get(i).getId());
            Assert.assertEquals(String.valueOf(bInformationSourcesList.get(i).getIsConsulted()), informationSourcesList.get(i).getIsConsulted());
        }

        //Assertions for Product
        Product product = requestTransactionCmlct001_1.getProduct();
        Assert.assertNotNull(product);
        Assert.assertEquals(bBody.getProduct().getId(), product.getId());
        Assert.assertEquals(bBody.getProduct().getName(), product.getName());

    }



    class DummyMock {

        public BBody getBBody() {
            BBody bBody = new BBody();

            BPerson bPerson = new BPerson();
            BIdentityDocument bIdentityDocument = new BIdentityDocument();
            bIdentityDocument.setDocumentType("Passport");
            bIdentityDocument.setDocumentNumber("123456789");
            bPerson.setIdentityDocument(bIdentityDocument);
            bPerson.setFirstName("John");
            bPerson.setMiddleName("Doe");
            bPerson.setLastName("Smith");

            BLaboralInformation bLaboralInformation = new BLaboralInformation();
            bLaboralInformation.setCompanyId("ACME Corp");
            bLaboralInformation.setDeclaratedIncome(Double.valueOf(50000));
            bPerson.setLaboralInformation(bLaboralInformation);
            bBody.setPerson(bPerson);


            List<BInformationSources> bInformationSourcesList = new ArrayList<>();
            BInformationSources bInformationSources1 = new BInformationSources();
            bInformationSources1.setId("Source1");
            bInformationSources1.setIsConsulted(true);
            bInformationSourcesList.add(bInformationSources1);

            BInformationSources bInformationSources2 = new BInformationSources();
            bInformationSources2.setId("Source2");
            bInformationSources2.setIsConsulted(false);
            bInformationSourcesList.add(bInformationSources2);

            bBody.setInformationSources(bInformationSourcesList);


            BProduct bProduct = new BProduct();
            bProduct.setId("Product123");
            bProduct.setName("Loan");
            bBody.setProduct(bProduct);

            return bBody;
        }
    }
}
