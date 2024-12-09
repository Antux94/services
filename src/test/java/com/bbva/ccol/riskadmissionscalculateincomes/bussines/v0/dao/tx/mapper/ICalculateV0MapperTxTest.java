
package com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.tx.mapper;

import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.in.InformationSources;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dao.model.cmlct001_1.in.RequestTransactionCmlct001_1;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dto.BBody;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dto.BIdentityDocument;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dto.BInformationSources;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dto.BLaboralInformation;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dto.BPerson;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dto.BProduct;
import java.util.ArrayList;
import java.util.List;
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
        Assert.assertEquals(bBody.getPerson().getLaboralInformation().getDeclaratedIncome(), Long.valueOf(request.getPerson().getLaboralInformation().getDeclaratedIncome()));

        List<BInformationSources> bInformationSourcesList = bBody.getInformationSources();
        List<InformationSources> informationSourcesList = request.getInformationSources();

        for (int i = 0; i < bInformationSourcesList.size(); i++) {
            Assert.assertEquals(bInformationSourcesList.get(i).getId(), informationSourcesList.get(i).getId());
            Assert.assertEquals(bInformationSourcesList.get(i).getIsConsulted().toString(), informationSourcesList.get(i).getIsConsulted());
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
            bIdentityDocument.setDocumentNumber("1235489345");
            bPerson.setIdentityDocument(bIdentityDocument);
            bPerson.setFirstName("Christian");
            bPerson.setMiddleName("David");
            bPerson.setLastName("Rojas");
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
