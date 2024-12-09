
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
    public void testMapInApxData() {
        BBody bBody = dummyMock.getBBody();
        RequestTransactionCmlct001_1 request = mapper.mapInApxData(bBody);

        // Assertions for RequestTransactionCmlct001_1
        Assert.assertNotNull(request);

        // Assertions for Person
        Person person = request.getPerson();
        Assert.assertNotNull(person);
        Assert.assertEquals(bBody.getPerson().getIdentityDocument().getDocumentType(), person.getIdentityDocument().getDocumentType());
        Assert.assertEquals(bBody.getPerson().getIdentityDocument().getDocumentNumber(), person.getIdentityDocument().getDocumentNumber());
        Assert.assertEquals(bBody.getPerson().getFirstName(), person.getFirstName());
        Assert.assertEquals(bBody.getPerson().getMiddleName(), person.getMiddleName());
        Assert.assertEquals(bBody.getPerson().getLastName(), person.getLastName());

        // Assertions for LaboralInformation
        LaboralInformation laboralInformation = person.getLaboralInformation();
        Assert.assertNotNull(laboralInformation);
        Assert.assertEquals(bBody.getPerson().getLaboralInformation().getCompanyId(), laboralInformation.getCompanyId());
        Assert.assertEquals(bBody.getPerson().getLaboralInformation().getDeclaratedIncome().longValue(), laboralInformation.getDeclaratedIncome());


        // Assertions for InformationSources
        List<InformationSources> informationSourcesList = request.getInformationSources();
        Assert.assertNotNull(informationSourcesList);
        Assert.assertEquals(bBody.getInformationSources().size(), informationSourcesList.size());
        for (int i = 0; i < informationSourcesList.size(); i++) {
            Assert.assertEquals(bBody.getInformationSources().get(i).getId(), informationSourcesList.get(i).getId());
            Assert.assertEquals(String.valueOf(bBody.getInformationSources().get(i).getIsConsulted()), informationSourcesList.get(i).getIsConsulted());
        }

        // Assertions for Product
        Product product = request.getProduct();
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
            bPerson.setMiddleName("David");
            bPerson.setLastName("Doe");

            BLaboralInformation bLaboralInformation = new BLaboralInformation();
            bLaboralInformation.setCompanyId("ACME Corp");
            bLaboralInformation.setDeclaratedIncome(100000.0); // Using Double for BLaboralInformation
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
            bProduct.setName("Awesome Product");
            bBody.setProduct(bProduct);

            return bBody;
        }
    }
}
