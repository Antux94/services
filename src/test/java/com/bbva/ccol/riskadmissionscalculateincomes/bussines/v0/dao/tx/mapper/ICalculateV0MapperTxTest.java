
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

    private DummyMock dummyMock;

    @Before
    public void setUp() {
        dummyMock = new DummyMock();
    }

    @Test
    public void testMapInApxData() {
        BBody bBody = dummyMock.getBBody();
        RequestTransactionCmlct001_1 request = mapper.mapInApxData(bBody);

        Assert.assertEquals(bBody.getPerson().getIdentityDocument().getDocumentType(), request.getPerson().getIdentityDocument().getDocumentType());
        Assert.assertEquals(bBody.getPerson().getIdentityDocument().getDocumentNumber(), request.getPerson().getIdentityDocument().getDocumentNumber());
        Assert.assertEquals(bBody.getPerson().getFirstName(), request.getPerson().getFirstName());
        Assert.assertEquals(bBody.getPerson().getMiddleName(), request.getPerson().getMiddleName());
        Assert.assertEquals(bBody.getPerson().getLastName(), request.getPerson().getLastName());
        Assert.assertEquals(bBody.getPerson().getLaboralInformation().getCompanyId(), request.getPerson().getLaboralInformation().getCompanyId());
        Assert.assertEquals(Long.valueOf(bBody.getPerson().getLaboralInformation().getDeclaratedIncome().longValue()), request.getPerson().getLaboralInformation().getDeclaratedIncome());

        for (int i = 0; i < bBody.getInformationSources().size(); i++) {
            Assert.assertEquals(bBody.getInformationSources().get(i).getId(), request.getInformationSources().get(i).getId());
            Assert.assertEquals(String.valueOf(bBody.getInformationSources().get(i).getIsConsulted()), request.getInformationSources().get(i).getIsConsulted());
        }

        Assert.assertEquals(bBody.getProduct().getId(), request.getProduct().getId());
        Assert.assertEquals(bBody.getProduct().getName(), request.getProduct().getName());

    }


    private class DummyMock {

        public BBody getBBody() {
            BBody bBody = new BBody();

            BPerson bPerson = new BPerson();
            BIdentityDocument bIdentityDocument = new BIdentityDocument();
            bIdentityDocument.setDocumentType("CC");
            bIdentityDocument.setDocumentNumber("12345");
            bPerson.setIdentityDocument(bIdentityDocument);
            bPerson.setFirstName("John");
            bPerson.setMiddleName("David");
            bPerson.setLastName("Doe");

            BLaboralInformation bLaboralInformation = new BLaboralInformation();
            bLaboralInformation.setCompanyId("BBVA");
            bLaboralInformation.setDeclaratedIncome(Double.valueOf(1000));
            bPerson.setLaboralInformation(bLaboralInformation);
            bBody.setPerson(bPerson);

            List<BInformationSources> bInformationSourcesList = new ArrayList<>();
            BInformationSources bInformationSources = new BInformationSources();
            bInformationSources.setId("1");
            bInformationSources.setIsConsulted(Boolean.TRUE);
            bInformationSourcesList.add(bInformationSources);
            bBody.setInformationSources(bInformationSourcesList);

            BProduct bProduct = new BProduct();
            bProduct.setId("product123");
            bProduct.setName("Credit Card");
            bBody.setProduct(bProduct);

            return bBody;
        }
    }
}
