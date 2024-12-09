
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
        BBody bBody = dummyMock.getBBody();
        RequestTransactionCmlct001_1 request = mapper.mapInApxData(bBody);

        Assert.assertNotNull(request);

        Person person = request.getPerson();
        Assert.assertNotNull(person);
        Assert.assertEquals(bBody.getPerson().getFirstName(), person.getFirstName());
        Assert.assertEquals(bBody.getPerson().getMiddleName(), person.getMiddleName());
        Assert.assertEquals(bBody.getPerson().getLastName(), person.getLastName());

        IdentityDocument identityDocument = person.getIdentityDocument();
        Assert.assertNotNull(identityDocument);
        Assert.assertEquals(bBody.getPerson().getIdentityDocument().getDocumentType(), identityDocument.getDocumentType());
        Assert.assertEquals(bBody.getPerson().getIdentityDocument().getDocumentNumber(), identityDocument.getDocumentNumber());

        LaboralInformation laboralInformation = person.getLaboralInformation();
        Assert.assertNotNull(laboralInformation);
        Assert.assertEquals(bBody.getPerson().getLaboralInformation().getCompanyId(), laboralInformation.getCompanyId());
        Assert.assertEquals(bBody.getPerson().getLaboralInformation().getDeclaratedIncome().longValue(), laboralInformation.getDeclaratedIncome());


        List<InformationSources> informationSources = request.getInformationSources();
        Assert.assertNotNull(informationSources);
        Assert.assertEquals(bBody.getInformationSources().size(), informationSources.size());
        for (int i = 0; i < informationSources.size(); i++) {
            Assert.assertEquals(bBody.getInformationSources().get(i).getId(), informationSources.get(i).getId());
            Assert.assertEquals(String.valueOf(bBody.getInformationSources().get(i).getIsConsulted()), informationSources.get(i).getIsConsulted());
        }

        Product product = request.getProduct();
        Assert.assertNotNull(product);
        Assert.assertEquals(bBody.getProduct().getId(), product.getId());
        Assert.assertEquals(bBody.getProduct().getName(), product.getName());
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
            bLaboralInformation.setDeclaratedIncome(Double.valueOf(5000000));
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
