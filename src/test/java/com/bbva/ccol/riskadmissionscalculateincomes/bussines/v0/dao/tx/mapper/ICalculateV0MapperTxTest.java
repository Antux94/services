
package com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.tx.mapper;

import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.in.*;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dto.*;
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
        BBody bBody = dummyMock.getBBody();
        RequestTransactionCmlct001_1 request = mapper.mapInApxData(bBody);

        // Person Assertions
        BPerson bPerson = bBody.getPerson();
        Person person = request.getPerson();
        Assert.assertEquals(bPerson.getFirstName(), person.getFirstName());
        Assert.assertEquals(bPerson.getMiddleName(), person.getMiddleName());
        Assert.assertEquals(bPerson.getLastName(), person.getLastName());

        // IdentityDocument Assertions
        BIdentityDocument bIdentityDocument = bPerson.getIdentityDocument();
        IdentityDocument identityDocument = person.getIdentityDocument();
        Assert.assertEquals(bIdentityDocument.getDocumentType(), identityDocument.getDocumentType());
        Assert.assertEquals(bIdentityDocument.getDocumentNumber(), identityDocument.getDocumentNumber());

        // LaboralInformation Assertions
        BLaboralInformation bLaboralInformation = bPerson.getLaboralInformation();
        LaboralInformation laboralInformation = person.getLaboralInformation();
        Assert.assertEquals(bLaboralInformation.getCompanyId(), laboralInformation.getCompanyId());
        Assert.assertEquals(Double.valueOf(bLaboralInformation.getDeclaratedIncome()), Double.valueOf(laboralInformation.getDeclaratedIncome()));


        // InformationSources Assertions
        List<BInformationSources> bInformationSourcesList = bBody.getInformationSources();
        List<InformationSources> informationSourcesList = request.getInformationSources();
        Assert.assertEquals(bInformationSourcesList.size(), informationSourcesList.size());
        for (int i = 0; i < bInformationSourcesList.size(); i++) {
            BInformationSources bInformationSources = bInformationSourcesList.get(i);
            InformationSources informationSources = informationSourcesList.get(i);
            Assert.assertEquals(bInformationSources.getId(), informationSources.getId());
            Assert.assertEquals(String.valueOf(bInformationSources.getIsConsulted()), informationSources.getIsConsulted());
        }

        // Product Assertions
        BProduct bProduct = bBody.getProduct();
        Product product = request.getProduct();
        Assert.assertEquals(bProduct.getId(), product.getId());
        Assert.assertEquals(bProduct.getName(), product.getName());
    }


    private class DummyMock {

        public BBody getBBody() {
            BBody bBody = new BBody();

            BPerson bPerson = new BPerson();
            bPerson.setFirstName("Christian");
            bPerson.setMiddleName("David");
            bPerson.setLastName("Rojas");

            BIdentityDocument bIdentityDocument = new BIdentityDocument();
            bIdentityDocument.setDocumentType("CC");
            bIdentityDocument.setDocumentNumber("1235489345");
            bPerson.setIdentityDocument(bIdentityDocument);

            BLaboralInformation bLaboralInformation = new BLaboralInformation();
            bLaboralInformation.setCompanyId("800900231-5");
            bLaboralInformation.setDeclaratedIncome(5000000.0);
            bPerson.setLaboralInformation(bLaboralInformation);

            bBody.setPerson(bPerson);

            List<BInformationSources> bInformationSourcesList = new ArrayList<>();
            BInformationSources bInformationSources = new BInformationSources();
            bInformationSources.setId("SOI");
            bInformationSources.setIsConsulted(false);
            bInformationSourcesList.add(bInformationSources);
            bBody.setInformationSources(bInformationSourcesList);

            BProduct bProduct = new BProduct();
            bProduct.setId("12");
            bProduct.setName("hipotecas");
            bBody.setProduct(bProduct);

            return bBody;
        }
    }
}
