
package com.bbva.ccol.riskadmissionscalculateincomes.facade.v0.mapper;

import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dto.BBody;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dto.BIdentityDocument;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dto.BInformationSources;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dto.BLaboralInformation;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dto.BPerson;
import com.bbva.ccol.riskadmissionscalculateincomes.business.v0.dto.BProduct;
import com.bbva.ccol.riskadmissionscalculateincomes.facade.v0.dto.Body;
import com.bbva.ccol.riskadmissionscalculateincomes.facade.v0.dto.IdentityDocument;
import com.bbva.ccol.riskadmissionscalculateincomes.facade.v0.dto.InformationSources;
import com.bbva.ccol.riskadmissionscalculateincomes.facade.v0.dto.LaboralInformation;
import com.bbva.ccol.riskadmissionscalculateincomes.facade.v0.dto.Person;
import com.bbva.ccol.riskadmissionscalculateincomes.facade.v0.dto.Product;
import java.util.List;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class IPostRiskAdmissionsCalculateIncomesMapperTest {

    private IPostRiskAdmissionsCalculateIncomesMapper mapper = Mappers.getMapper(IPostRiskAdmissionsCalculateIncomesMapper.class);

    private DummyMock dummyMock;

    @Before
    public void setUp() {
        dummyMock = new DummyMock();
    }

    @Test
    public void testMapInData() {
        Body body = dummyMock.getBody();
        BBody bBody = mapper.mapInData(body);

        Assert.assertEquals(body.getPerson().getIdentityDocument().getDocumentType(), bBody.getPerson().getIdentityDocument().getDocumentType());
        Assert.assertEquals(body.getPerson().getIdentityDocument().getDocumentNumber(), bBody.getPerson().getIdentityDocument().getDocumentNumber());
        Assert.assertEquals(body.getPerson().getFirstName(), bBody.getPerson().getFirstName());
        Assert.assertEquals(body.getPerson().getMiddleName(), bBody.getPerson().getMiddleName());
        Assert.assertEquals(body.getPerson().getLastName(), bBody.getPerson().getLastName());
        Assert.assertEquals(body.getPerson().getLaboralInformation().getCompanyId(), bBody.getPerson().getLaboralInformation().getCompanyId());
        Assert.assertEquals(body.getPerson().getLaboralInformation().getDeclaratedIncome(), bBody.getPerson().getLaboralInformation().getDeclaratedIncome());

        Assert.assertEquals(body.getInformationSources().get(0).getId(), bBody.getInformationSources().get(0).getId());
        Assert.assertEquals(body.getInformationSources().get(0).getIsConsulted(), bBody.getInformationSources().get(0).getIsConsulted());

        Assert.assertEquals(body.getProduct().getId(), bBody.getProduct().getId());
        Assert.assertEquals(body.getProduct().getName(), bBody.getProduct().getName());

    }

    @Test
    public void testMapOutData() {
        BBody bBody = dummyMock.getBBody();
        Body body = mapper.mapOutData(bBody);

        Assert.assertEquals(bBody.getPerson().getIdentityDocument().getDocumentType(), body.getPerson().getIdentityDocument().getDocumentType());
        Assert.assertEquals(bBody.getPerson().getIdentityDocument().getDocumentNumber(), body.getPerson().getIdentityDocument().getDocumentNumber());
        Assert.assertEquals(bBody.getPerson().getFirstName(), body.getPerson().getFirstName());
        Assert.assertEquals(bBody.getPerson().getMiddleName(), body.getPerson().getMiddleName());
        Assert.assertEquals(bBody.getPerson().getLastName(), body.getPerson().getLastName());
        Assert.assertEquals(bBody.getPerson().getLaboralInformation().getCompanyId(), body.getPerson().getLaboralInformation().getCompanyId());
        Assert.assertEquals(bBody.getPerson().getLaboralInformation().getDeclaratedIncome(), body.getPerson().getLaboralInformation().getDeclaratedIncome());

        Assert.assertEquals(bBody.getInformationSources().get(0).getId(), body.getInformationSources().get(0).getId());
        Assert.assertEquals(bBody.getInformationSources().get(0).getIsConsulted(), body.getInformationSources().get(0).getIsConsulted());

        Assert.assertEquals(bBody.getProduct().getId(), body.getProduct().getId());
        Assert.assertEquals(bBody.getProduct().getName(), body.getProduct().getName());
    }


    private class DummyMock {

        public Body getBody() {
            Body body = new Body();
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
            laboralInformation.setDeclaratedIncome(Double.valueOf(5000000));
            person.setLaboralInformation(laboralInformation);
            body.setPerson(person);

            List<InformationSources> informationSourcesList = new ArrayList<>();
            InformationSources informationSources = new InformationSources();
            informationSources.setId("SOI");
            informationSources.setIsConsulted(false);
            informationSourcesList.add(informationSources);
            body.setInformationSources(informationSourcesList);

            Product product = new Product();
            product.setId("12");
            product.setName("hipotecas");
            body.setProduct(product);

            return body;
        }


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
